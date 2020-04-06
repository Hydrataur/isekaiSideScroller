public class Surface {

    private int x, y, width, height;

    public Surface(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean characterOverlap(character c, int xModifier, int yModifier){
        int cLeftX = c.getX() + xModifier, cRightX = cLeftX + c.getImg_width();
        int cTopY = c.getY() + yModifier, cBotY = cTopY + c.getImg_height();

        if (cRightX > this.x && cLeftX < this.x || cLeftX < this.x + this.width && cRightX > this.x + this.width)
            return cBotY > this.y && cTopY < this.y + this.height;

        return false;
    }
}
