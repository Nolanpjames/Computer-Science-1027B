public class TestLab {
    public static void main(String[] args) {
        Player p1 = new Player("Justin Yan","defenceman", 2);

        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        p1.setName("Mason Raymond");
        p1.setPosition("Left Wing");
        p1.setJerseyNum(21);

        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        System.out.println(p1);

        Player p2 = new Player("Mason Raymond", "Left Wing", 21);

        if (p1.equals(p2)) {
            System.out.println("Same player");
        } else {
            System.out.println("Different player");
        }

    }
}
