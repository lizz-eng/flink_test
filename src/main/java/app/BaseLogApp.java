package app;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class BaseLogApp {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 读取本地文件
        String filePath = "file:///path/to/your/file.txt";
        env.readTextFile(filePath)
                // 将每行文本转换为 Tuple2<String, Integer>，其中 Integer 为行号
                .map(new MapFunction<String, String>() {
                    @Override
                    public String map(String s) throws Exception {
                        return null;
                    }
                })
                // 将结果写入到控制台和文件中
                .writeAsText("file:///path/to/your/output.txt", FileSystem.WriteMode.OVERWRITE);

        // 执行任务
        env.execute("Read Local File Example");
    }
}
