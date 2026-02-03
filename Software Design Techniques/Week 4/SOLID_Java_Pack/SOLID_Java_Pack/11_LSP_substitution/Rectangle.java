public class Rectangle implements RectangleLike {
    private int w;
    private int h;
    @Override public void setWidth(int w) { this.w = w; }
    @Override public void setHeight(int h) { this.h = h; }
    @Override public int area() { return w * h; }
}
