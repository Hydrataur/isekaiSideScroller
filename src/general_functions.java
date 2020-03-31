public class general_functions {

    public static boolean checkHorizontalCollisions(character chara, Surface[] surfaces){
        for (Surface surf : surfaces) {
            if (chara.isMoving_right())
                if (chara.getX() + chara.getImg_width() < surf.getX() && chara.getX() + chara.getImg_width() + chara.getMovement_speed() >= surf.getX())
                    if (chara.getY() + chara.getImg_height() > surf.getY()) {
                        if (chara instanceof Enemy) {
                            chara.setMoving_right(false);
                            chara.setMoving_left(true);
                            chara.setDirection_right(false);
                        }
                        return true;
                    }
            if (chara.isMoving_left())
                if (chara.getX() > surf.getX() + surf.getWidth() && chara.getX() - chara.getMovement_speed() <= surf.getX() + surf.getWidth())
                    if (chara.getY() + chara.getImg_height() > surf.getY()) {
                        if (chara instanceof Enemy) {
                            chara.setMoving_right(true);
                            chara.setMoving_left(false);
                            chara.setDirection_right(true);
                        }
                        return true;
                    }
        }
        return false;
    }

    public static boolean checkVerticalCollisions(character chara, Surface[] surfaces){
        for (Surface surface : surfaces){
            if (chara.getY() + chara.getImg_height() >= surface.getY() &&
            chara.getX() + chara.getImg_width() >= surface.getX() && chara.getX() <= surface.getX() + surface.getWidth()) {
                chara.setY(surface.getY() - chara.getImg_height());
                return true;
            }
        }
        return false;
    }

}
