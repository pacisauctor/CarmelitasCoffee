package com.carmelitascoffee.vista.inicio;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class FullResizibleFrame implements MouseMotionListener, MouseListener {

    private JFrame jFrame;
    private static final long serialVersionUID = 1L;
    private Point start_drag;
    private Point start_loc;
    private Point precedent_loc;
    private int precedent_width;
    private int precedent_height;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    private int minWidth;
    private int minHeight;
    private Point initialLocation;
    int cursorArea = 5;
    Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    private int DIFF_MIN_WIDTH = 30;
    private int DIFF_MIN_HEIGHT = 30;

    public FullResizibleFrame(Dimension initialDimension, Point initialLocation, JFrame jFrame) {
        this.initialLocation = initialLocation;
        minWidth = (int) initialDimension.getWidth();
        minHeight = (int) initialDimension.getHeight();
        this.jFrame = jFrame;
        Init();
    }

    private void Init() {
        jFrame.addMouseMotionListener(this);
        jFrame.addMouseListener(this);
        jFrame.setSize(minWidth, minHeight);

        minWidth -= DIFF_MIN_WIDTH;
        minHeight -= DIFF_MIN_HEIGHT;

        jFrame.setLocation(initialLocation);
        jFrame.setUndecorated(true);
    }

    public static Point getScreenLocation(MouseEvent e, JFrame frame) {
        Point cursor = e.getPoint();
        Point view_location = frame.getLocationOnScreen();
        return new Point((int) (view_location.getX() + cursor.getX()),
                (int) (view_location.getY() + cursor.getY()));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        moveOrFullResizeFrame(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point cursorLocation = e.getPoint();
        int xPos = cursorLocation.x;
        int yPos = cursorLocation.y;

        if (xPos >= cursorArea && xPos <= jFrame.getWidth() - cursorArea && yPos >= jFrame.getHeight() - cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
        } else if (xPos >= jFrame.getWidth() - cursorArea && yPos >= cursorArea && yPos <= jFrame.getHeight() - cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        } else if (xPos <= cursorArea && yPos >= cursorArea && yPos <= jFrame.getHeight() - cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
        } else if (xPos >= cursorArea && xPos <= jFrame.getWidth() - cursorArea && yPos <= cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
        } else if (xPos <= cursorArea && yPos <= cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
        } else if (xPos >= jFrame.getWidth() - cursorArea && yPos <= cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
        } else if (xPos >= jFrame.getWidth() - cursorArea && yPos >= jFrame.getHeight() - cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        } else if (xPos <= cursorArea && yPos >= jFrame.getHeight() - cursorArea) {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
        } else {
            jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object sourceObject = e.getSource();
        if (sourceObject instanceof JPanel) {
            if (e.getClickCount() == 2) {
                if (jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR))) {
                    headerDoubleClickResize();
                }
            }
        }
    }

    private void moveOrFullResizeFrame(MouseEvent e) {
        Object sourceObject = e.getSource();
        Point current = getScreenLocation(e, jFrame);
        Point offset = new Point((int) current.getX() - (int) start_drag.getX(), (int) current.getY() - (int) start_drag.getY());

        if (sourceObject instanceof JPanel
                && jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR))) {
            jFrame.setLocation((int) (start_loc.getX() + offset.getX()), (int) (start_loc.getY() + offset.getY()));
        } else if (!jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR))) {
            int oldLocationX = (int) jFrame.getLocation().getX();
            int oldLocationY = (int) jFrame.getLocation().getY();
            int newLocationX = (int) (this.start_loc.getX() + offset.getX());
            int newLocationY = (int) (this.start_loc.getY() + offset.getY());
            boolean N_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
            boolean NE_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
            boolean NW_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
            boolean E_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
            boolean W_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
            boolean S_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
            boolean SW_Resize = jFrame.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
            boolean setLocation = false;
            int newWidth = e.getX();
            int newHeight = e.getY();

            if (NE_Resize) {
                newHeight = jFrame.getHeight() - (newLocationY - oldLocationY);
                newLocationX = (int) jFrame.getLocation().getX();
                setLocation = true;
            } else if (E_Resize) {
                newHeight = jFrame.getHeight();
            } else if (S_Resize) {
                newWidth = jFrame.getWidth();
            } else if (N_Resize) {
                newLocationX = (int) jFrame.getLocation().getX();
                newWidth = jFrame.getWidth();
                newHeight = jFrame.getHeight() - (newLocationY - oldLocationY);
                setLocation = true;
            } else if (NW_Resize) {
                newWidth = jFrame.getWidth() - (newLocationX - oldLocationX);
                newHeight = jFrame.getHeight() - (newLocationY - oldLocationY);
                setLocation = true;
            } else if (NE_Resize) {
                newHeight = jFrame.getHeight() - (newLocationY - oldLocationY);
                newLocationX = (int) jFrame.getLocation().getX();
            } else if (SW_Resize) {
                newWidth = jFrame.getWidth() - (newLocationX - oldLocationX);
                newLocationY = (int) jFrame.getLocation().getY();
                setLocation = true;
            }
            if (W_Resize) {
                newWidth = jFrame.getWidth() - (newLocationX - oldLocationX);
                newLocationY = (int) jFrame.getLocation().getY();
                newHeight = jFrame.getHeight();
                setLocation = true;
            }

            if (newWidth >= (int) toolkit.getScreenSize().getWidth() || newWidth <= minWidth) {
                newLocationX = oldLocationX;
                newWidth = jFrame.getWidth();
            }

            if (newHeight >= (int) toolkit.getScreenSize().getHeight() - 30 || newHeight <= minHeight) {
                newLocationY = oldLocationY;
                newHeight = jFrame.getHeight();
            }

            if (newWidth != jFrame.getWidth() || newHeight != jFrame.getHeight()) {
                jFrame.setSize(newWidth, newHeight);

                if (setLocation) {
                    jFrame.setLocation(newLocationX, newLocationY);
                }
            }
        }
    }

    private void headerDoubleClickResize() {
        if (jFrame.getWidth() < screen.getWidth() || jFrame.getHeight() < screen.getHeight()) {
            jFrame.setSize((int) screen.getWidth(), (int) screen.getHeight());
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = jFrame.getSize();
            jFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        } else {
            jFrame.setSize(precedent_width, precedent_height);
            jFrame.setLocation(precedent_loc);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.start_drag = getScreenLocation(e, jFrame);
        this.start_loc = jFrame.getLocation();

        if (jFrame.getWidth() < screen.getWidth() || jFrame.getHeight() < screen.getHeight()) {
            precedent_loc = jFrame.getLocation();
            precedent_width = jFrame.getWidth();
            precedent_height = jFrame.getHeight();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
