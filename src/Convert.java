import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Convert {

    private static  BigDecimal START_HEIGHT = new BigDecimal("57.3057569402");
    private static  BigDecimal START_WIDTH = new BigDecimal("65.2666960740");
    private static  BigDecimal END_HEIGHT = new BigDecimal("57.060523480");
    private static  BigDecimal END_WIDTH = new BigDecimal("65.8539518946");
    private static  BigDecimal STEP_OF_HEIGHT;
    private static  BigDecimal STEP_OF_WIDTH;
    private static  int HEIGHT;
    private static  int WIDTH;
    private static MathContext mc = new MathContext(10, RoundingMode.DOWN);

    public static void main(String[] args) {

    }

    public static void initSteps(int height, int width){
        HEIGHT = height;
        WIDTH = width;
        STEP_OF_HEIGHT = (START_HEIGHT.subtract(END_HEIGHT))
                .divide(new BigDecimal(Integer.toString(HEIGHT)), mc);
        STEP_OF_WIDTH = (END_WIDTH.subtract(START_WIDTH))
                .divide(new BigDecimal(Integer.toString(WIDTH)), mc);
    }

    //Широта
    public static int getHeightCount(BigDecimal heightCoordinate) {
        heightCoordinate = START_HEIGHT.subtract(heightCoordinate);
        heightCoordinate = heightCoordinate.divide(STEP_OF_HEIGHT, mc);
        return Integer.valueOf(heightCoordinate.intValue());
    }

    //Долгота
    public static int getWidthCount(BigDecimal widthCoordinate) {
        widthCoordinate = widthCoordinate.subtract(START_WIDTH);
        widthCoordinate = widthCoordinate.divide(STEP_OF_WIDTH, mc);
        return Integer.valueOf(widthCoordinate.intValue());
    }

    public static int getKeyOnTheCoordinates(int height, int width, BigDecimal heightCoordinate, BigDecimal widthCoordinate) {
        initSteps(height, width);
        return getHeightCount(heightCoordinate) * WIDTH + getWidthCount(widthCoordinate);
    }

}
