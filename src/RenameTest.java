package com.ifeng.bigdata.hadoop;

import com.ifeng.bigdata.junit.RenameT1;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RenameTest {

    static RenameT1 rn;
    FileSystem fileSystem;


    @Before
    public void setUp() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("dfs.replication","1");
        URI uri = new URI("hdfs://10.103.66.15:9000");
        fileSystem = FileSystem.get(uri, conf, "ifeng");

        rn = new RenameT1();

        System.out.println("=============================setUP=============================");
    }
    @After
    public void tearDown() throws IOException {
        rn = null;
        if(null != fileSystem){
            fileSystem.close();
        }
    }

    @Test
    public void testRename() throws IOException {
        rn.rename(20200706);
    }


}
