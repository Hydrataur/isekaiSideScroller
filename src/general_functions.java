public class general_functions {

    public static boolean checkCollisions(character chara, surface[] surfaces){
        for (surface surf : surfaces) {
            if (chara.isMoving_right())
                if (chara.getX() + chara.getImg_width() < surf.getX() && chara.getX() + chara.getImg_width() + chara.getMovement_speed() >= surf.getX())
                    return true;
            if (chara.isMoving_left())
                if (chara.getX() > surf.getX() + surf.getWidth() && chara.getX() - chara.getMovement_speed() <= surf.getX() + surf.getWidth())
                    return true;
        }
        return false;
    }

}
