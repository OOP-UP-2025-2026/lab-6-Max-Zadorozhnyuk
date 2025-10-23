package ua.opnu.model;

import java.awt.*;

public abstract class DrawShape {

    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    public static DrawShape newInstance(int shapeType) {
        DrawShape shape = null;
        switch (shapeType) {
            case SHAPE_RECTANGLE -> shape = new Rectangle();
            case SHAPE_ROUNDED_RECT -> shape = new RoundedRectangle();
            case SHAPE_ELLIPSE -> shape = new Ellipse();
        }
        return shape;
    }

    private Point startPoint;
    private Point endPoint;

    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Тепер абстрактний метод — обов'язковий для перевизначення у підкласах
    public abstract Shape getShape(Point startPoint, Point endPoint);

    public Shape getShape() {
        return getShape(startPoint, endPoint);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}