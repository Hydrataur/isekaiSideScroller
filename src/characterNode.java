public class characterNode {

    character Character;
    characterNode next;

    public characterNode(character Character, characterNode next){
        this.Character = Character;
        this.next = next;
    }

    public character getCharacter() {
        return Character;
    }

    public characterNode getNext() {
        return next;
    }

    public void setNext(characterNode next) {
        this.next = next;
    }

    public int getLength(){
        characterNode p = this;
        int counter = 0;

        while(p.getNext() != null){
            p = p.getNext();
            counter++;
        }

        return counter;
    }

}
