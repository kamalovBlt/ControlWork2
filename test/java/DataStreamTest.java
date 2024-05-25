import org.example.DataStream;
import org.junit.Assert;
import org.junit.Test;

public class DataStreamTest {
    @Test
    public void chetnTestByRandomNum() {
        DataStream dataStream = new DataStream("");
        byte[] nums = {5, 6, 1, 5}; //101 110 1 101
        Assert.assertEquals(1, dataStream.cheth(nums));
    }
    @Test
    public void chetnTestByNullArray() {
        DataStream dataStream = new DataStream("");
        byte[] nums = {}; //101 110 1 101
        Assert.assertEquals(0, dataStream.cheth(nums));
    }
    @Test
    public void chetnTestByOnly1Array() {
        DataStream dataStream = new DataStream("");
        byte[] nums = {1, 1, 1, 1, 1};
        Assert.assertEquals(1, dataStream.cheth(nums));
    }

    @Test
    public void chetnTestByOnly0Array() {
        DataStream dataStream = new DataStream("");
        byte[] nums = {0, 0, 0, 0, 0};
        Assert.assertEquals(0, dataStream.cheth(nums));
    }

}
