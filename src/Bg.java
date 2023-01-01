import java.awt.*;
public class Bg {
    static int level = 1;
    int goal = level * 15;
    static int count = 0;
    static int diamondNum = 3;
    static boolean diamondFlag = false;
    long startTime;
    long endTime;
    int price = (int) (Math.random() * 10);
    boolean shop = false;
    Image bg = Toolkit.getDefaultToolkit().getImage("img/background.png");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("img/sky.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("img/senbird.png");
    Image logo = Toolkit.getDefaultToolkit().getImage("img/logo.png");
    void paintSelf(Graphics g) {
        g.drawImage(bg1, 0, 0, null);
        g.drawImage(bg, 0, 200, null);
        switch (GameWin.state) {
            case 0:
                g.drawImage(logo, 300, 220, null);
                drawWord(g, 70, Color.yellow, "森鸟矿工", 230, 450);
                drawWord(g, 50, Color.yellow, "右键开始游戏", 220, 550);
                break;
            case 1:
                g.drawImage(peo, 310, 50, null);
                drawWord(g, 30, Color.yellow, "金钱:$" + count*100, 30, 150);
                drawWord(g, 30, Color.cyan, "生力水x" + diamondNum, 510, 90);
                drawWord(g, 20, Color.white, "第关:" + level, 30, 60);
                drawWord(g, 30, Color.white, "目标钱数:$" + goal*100, 30, 110);
                endTime = System.currentTimeMillis();
                long tim = 20 - (endTime - startTime) / 1000;
                drawWord(g, 30, Color.white, "时间: " + (tim > 0 ? tim : 0), 520, 150);
                break;
            case 2:
                drawWord(g, 30, Color.YELLOW, "价格: " + price, 330, 500);
                drawWord(g, 30, Color.YELLOW, "是否购买增力水", 310, 550);
                if (shop) {
                    count = count - price;
                    diamondNum++;
                    shop = false;
                    GameWin.state = 1;
                    startTime = System.currentTimeMillis();
                }
                break;
            case 3:
                drawWord(g, 40, Color.YELLOW, "你触犯了矿工第114514条法律", 130, 380);
                drawWord(g, 50, Color.YELLOW, "构成未达到目标分罪", 170, 450);
                drawWord(g, 50, Color.YELLOW, "矿工：我要降你等地！！！", 130, 550);
                drawWord(g, 50, Color.YELLOW, "你共获得" + count +"点金钱", 200, 650);
                break;
            default:
        }
    }
    boolean gameTime() {
        long tim = (endTime - startTime) / 1000;
        if (tim > 20) {
            return true;
        }
        return false;
    }
    void reGame() {
        level = 1;
        goal = level * 15;
        count = 0;
        diamondNum = 3;
        diamondFlag = false;
    }
    public static void drawWord(Graphics g, int size, Color color, String str, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("Microsoft Yahei UI", Font.PLAIN, size));
        g.drawString(str, x, y);
    }
}
