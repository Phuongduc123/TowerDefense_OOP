import java.util.ArrayList;

public class NextLevel {
    private ArrayList<ArrayList<Enemy>> nextlevel;
    public NextLevel()
    {
        nextlevel = new ArrayList<ArrayList<Enemy>>();
        for ( int i = 0 ; i < 30 ; i ++)
            nextlevel.add(new ArrayList<Enemy>());

        for ( int i = 0 ; i < 5 ; i ++)
        {
            nextlevel.get(0).add(new NormalEnemy());
        }
        for ( int i = 0; i < 6 ; i ++ )
        {
            nextlevel.get(1).add(new NormalEnemy());
        }
        for ( int i = 0 ; i < 7 ; i ++ )
        {
            nextlevel.get(2).add(new NormalEnemy());
        }
        for ( int i = 0 ; i < 8 ; i ++ )
        {
            nextlevel.get(3).add(new NormalEnemy());
        }
        for ( int i = 0 ; i < 9 ; i ++ )
        {
            nextlevel.get(4).add(new NormalEnemy());
        }
        for ( int i = 0 ; i < 5 ; i ++ ) nextlevel.get(5).add(new SmallerEnemy());
        for (int i = 0 ; i < 10 ; i ++) nextlevel.get(6).add(new NormalEnemy());
        for ( int i = 0 ; i < 11 ; i ++  ) nextlevel.get(7) .add(new NormalEnemy());
        for ( int i = 0 ; i < 12 ; i ++) nextlevel.get(8).add(new NormalEnemy());
        nextlevel.get(9).add(new TankerEnemy());
        for ( int i =  0 ; i < 10 ; i ++ )
        {
            nextlevel.get(10).add(new SmallerEnemy());
            nextlevel.get(11).add(new SmallerEnemy());
        }
        for ( int i = 0 ; i < 15 ; i ++)
        {
            nextlevel.get(12).add(new NormalEnemy());
            nextlevel.get(13).add(new NormalEnemy());
        }
        nextlevel.get(14).add(new BossEnemy());
        for ( int i =0 ; i< 17; i ++)
        {
            nextlevel.get(15).add(new NormalEnemy());
            nextlevel.get(16).add(new NormalEnemy());
            nextlevel.get(17).add(new NormalEnemy());

        }
        for ( int i = 0 ; i < 12 ; i ++ ) nextlevel.get(18).add(new SmallerEnemy());
        nextlevel.get(19).add(new TankerEnemy() );
        nextlevel.get(19).add(new TankerEnemy());
        nextlevel.get(19).add(new TankerEnemy());
        for ( int i = 0 ; i < 15 ; i ++)
        {
            nextlevel.get(20).add(new SmallerEnemy());
            nextlevel.get(21).add(new SmallerEnemy());
            nextlevel.get(22).add(new SmallerEnemy());
        }
        for ( int i = 0;i < 20  ; i ++ ) nextlevel.get(23).add(new NormalEnemy());
        nextlevel.get(25).add(new BossEnemy() );
        nextlevel.get(25).add(new BossEnemy());
        for ( int i =0 ; i < 5 ; i ++ )
        {
            nextlevel.get(26).add(new TankerEnemy() );
            nextlevel.get(27).add(new TankerEnemy());
        }
        for (int i = 0 ; i < 22 ; i ++) nextlevel.get(28).add(new NormalEnemy() );
        for ( int i = 0 ; i < 17 ;i++) nextlevel.get(29).add(new SmallerEnemy());
        nextlevel.get(29).add(new BossEnemy() );
        nextlevel.get(29).add(new BossEnemy() );
        nextlevel.get(29).add(new BossEnemy() );
    }

    public ArrayList<ArrayList<Enemy>> getNextLevel() {
        return nextlevel;
    }
}
