import java.util.ArrayList;

public class NextLevel {
    private ArrayList<ArrayList<Enemy>> nextLevel;
    public NextLevel()
    {
        nextLevel = new ArrayList<ArrayList<Enemy>>();
        for (int i = 0 ; i < 10; i++) nextLevel.add(new ArrayList<Enemy>());

        for (int i = 0 ; i < 5; i++)
        {
            nextLevel.get(0).add(new NormalEnemy());
        }
        nextLevel.get(0).add(new TankerEnemy());
        for (int i = 0; i < 10; i++)
        {
            nextLevel.get(1).add(new NormalEnemy());
        }
        for (int i = 0; i < 5; i++)
        {
            nextLevel.get(2).add(new NormalEnemy());
            nextLevel.get(2).add(new SmallerEnemy());
        }
        for (int i = 0; i < 5; i++)
        {
            nextLevel.get(3).add(new NormalEnemy());
            nextLevel.get(3).add(new TankerEnemy());
        }
        for (int i = 0; i < 5; i++)
        {
            nextLevel.get(4).add(new NormalEnemy());
            nextLevel.get(4).add(new SmallerEnemy());
            nextLevel.get(4).add(new TankerEnemy());
        }
        for (int i = 0; i < 5; i++) {
            nextLevel.get(5).add(new SmallerEnemy());
            nextLevel.get(5).add(new TankerEnemy());
        }
        for (int i = 0; i < 3; i++) {
            nextLevel.get(6).add(new NormalEnemy());
            nextLevel.get(6).add(new TankerEnemy());
            nextLevel.get(6).add(new NormalEnemy());
        }
        for (int i = 0; i < 9; i++) {
            nextLevel.get(7).add(new NormalEnemy());
        }
        nextLevel.get(7).add(new BossEnemy());

        for (int i = 0; i < 4; i++) {
            nextLevel.get(8).add(new SmallerEnemy());
            nextLevel.get(8).add(new NormalEnemy());
        }
        for (int i = 0; i < 2; i++) {
            nextLevel.get(8).add(new BossEnemy());
        }

        nextLevel.get(9).add(new TankerEnemy());
        for (int i = 0; i < 5; i++) {
            nextLevel.get(9).add(new SmallerEnemy());
        }
        nextLevel.get(9).add(new TankerEnemy());
        nextLevel.get(9).add(new TankerEnemy());
        for (int i = 0; i < 5; i++) {
            nextLevel.get(9).add(new NormalEnemy());
        }
        nextLevel.get(9).add(new TankerEnemy());
        nextLevel.get(9).add(new BossEnemy());
        nextLevel.get(9).add(new TankerEnemy());
        nextLevel.get(9).add(new BossEnemy());
    }

    public ArrayList<ArrayList<Enemy>> getNextLevel() {
        return nextLevel;
    }
}
