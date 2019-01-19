package org.shancm.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapDriver;
import org.shancm.hadoop.temperature.MapDemo;

import java.io.IOException;

/**
 * @author shancm
 * @package org.shancm.hadoop
 * @description:
 * @date 2018/10/24
 */

public class MaxTemperatureMapperTest {

	public void runMapper() throws IOException {
		Text value = new Text("0029029070999991901010106004+64333+023450FM-12+000599999V0202701N015919999999N0000001N9-00781+99999102001ADDGF108991999999999999999999");
		new MapDriver<LongWritable, Text, Text, IntWritable>().withMapper(new MapDemo()).withInput(new LongWritable(0), value)
				.withOutput(new Text("1901"), new IntWritable(-11)).runTest();

	}

}
