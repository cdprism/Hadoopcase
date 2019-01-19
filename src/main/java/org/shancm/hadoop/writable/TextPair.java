package org.shancm.hadoop.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

/**
 * @author shancm
 * @package org.shancm.hadoop.writable
 * @description:
 * @date 2018/10/23
 */
public class TextPair implements WritableComparable<TextPair> {

	private Text first;
	private Text second;

	public TextPair() {
	}

	public Text getFirst() {
		return first;
	}

	public void setFirst(Text first) {
		this.first = first;
	}

	public Text getSecond() {
		return second;
	}

	public void setSecond(Text second) {
		this.second = second;
	}

	@Override
	public int compareTo(TextPair o) {
		/*if(Objects.isNull(0)){
			return 0;
		}
		if(o instanceof  TextPair){
			TextPair tp = o;
			return first.equals(tp.getFirst()) && second.equals(tp.getSecond());
		}*/
		return 0;
	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {

	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {

	}
}
