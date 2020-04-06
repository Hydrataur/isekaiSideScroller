import java.lang.reflect.Type;

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

    public static boolean checkEnemyCollisions(protag player, Enemy enemy){
        return player.getX() + player.getImg_width() >= enemy.getX() && player.getX() <= enemy.getX() + enemy.getImg_width()
                && player.getY() + player.getImg_height() >= enemy.getY() && player.getY() <= enemy.getY() + enemy.getImg_height();
    }

    public static void playerEnemyInteraction(protag player, Enemy enemy, Surface[] surfaces, Distance distance){
        if (player.getFalling_velocity() >= 0 && player.getY() + player.getImg_height() < enemy.getY() + enemy.getImg_height() / 2)
            enemy.setCurrent_HP(0);
        else {
            player.setCurrent_HP(player.getCurrent_HP() - 2);
            boolean playerTooCloseToWall = false;
            if (player.getX() < enemy.getX()) {
                for (Surface surface : surfaces)
                    if (surface.characterOverlap(player, -enemy.getKnockback(), 0)) {
                        playerTooCloseToWall = true;
                        break;
                    }

                if (playerTooCloseToWall) {
                    enemy.setX(enemy.getX() + enemy.getKnockback() * 2);
                }
                else {
                    player.setX(player.getX() - enemy.getKnockback());
                    distance.setxDis(distance.getxDis() - enemy.getKnockback());
                    enemy.setX(enemy.getX() + enemy.getKnockback());
                }
            }
            else {
                for (Surface surface : surfaces)
                    if (surface.characterOverlap(player, enemy.getKnockback(), 0)) {
                        playerTooCloseToWall = true;
                        break;
                    }

                if (playerTooCloseToWall) {
                    enemy.setX(enemy.getX() - enemy.getKnockback() * 2);
                }
                else {
                    player.setX(player.getX() + enemy.getKnockback());
                    distance.setxDis(distance.getxDis() + enemy.getKnockback());
                    enemy.setX(enemy.getX() - enemy.getKnockback());
                }
            }

        }
    }

    public static character[] returnRenderedCharacterArray(character[] characters, int screen_width, int screen_height, int distance){
        int x, y;
        characterNode node = new characterNode(characters[0], null);
        for (character c : characters) {
            x = c.getX() - distance;
            y = c.getY();
            if (c.getCurrent_HP() > 0)
                if (x > 0 && x < screen_width && y > 0 && y < screen_height)
                    node = new characterNode(c, node);

        }
        character[] rendered = new character[node.getLength()];
        int counter = 0;
        while (node.getNext() != null){
            rendered[counter] = node.getCharacter();
            counter++;
            node = node.getNext();
        }

        return rendered;
    }

}
