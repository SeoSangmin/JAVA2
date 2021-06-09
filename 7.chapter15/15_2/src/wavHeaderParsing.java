import java.io.FileInputStream;
import java.io.IOException;

class WaveHeaders{ //헤더 정보를 각각 저장할 수 있게. 
	String[] RIFF_NAME = {"ChunkID", "ChunkSize", "Format"};
	String[] FMT_NAME = {"fmt_chunkID", "fmt_chunkSize", 
			"audio_format", "num_channels", "sample_rate", 
			"byte_rate", "block_align", "pit_per_sample"};
	String[] DATA_NAME = {"data_chunkID", "data_chunkSize"};
	
	//RIFF members 
	byte[] ChunkID = new byte[4];
	byte[] ChunkSize = new byte[4];
	byte[] Format = new byte[4];
	
	//FMT members
	byte[] fmt_chunkID = new byte[4];
	byte[] fmt_chunkSize = new byte[4];
	byte[] audio_format = new byte[2];
	byte[] num_channels = new byte[2];
	byte[] sample_rate = new byte[4];
	byte[] byte_rate = new byte[4];
	byte[] block_align = new byte[2];
	byte[] pit_per_sample = new byte[2];
	
	//DATA members
	byte[] data_chunkID = new byte[4];
	byte[] data_chunkSize = new byte[4];
	
	
	
}
public class wavHeaderParsing {
	
	static int int_Data(byte[] int_byte) {
		int result = ( (int_byte[0]&0xff) | (int_byte[1]&0xff)<<8 
				| (int_byte[2]&0xff)<<16 | (int_byte[3]&0xff)<<24 );
		return result;
	}
	
	static short short_Data(byte[] short_byte) {
		short result = (short) ( (short_byte[0]&0xff) | (short_byte[1]&0xff)<<8 );
		return result;
	}
	
	static void showChar(int num, byte[] byteArr) {
		for(int i=0; i<num; i++) {
			System.out.print((char)byteArr[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Wave Header Parsing");
		String filePath = "/Users/seosangmin/Music/tada.wav"; //"C:\\Temp\\tada.wav"
		FileInputStream fin; 
		WaveHeaders wh = new WaveHeaders();
		
		byte int_byte[] = new byte[4];
		byte short_byte[] = new byte[2];
		
		try {
			System.out.println("\n[ Wave RIFF Header ] 해석");
			fin = new FileInputStream(filePath);
			fin.read(wh.ChunkID); //ChunkID 
			System.out.print(wh.RIFF_NAME[0]+" : ");
			showChar(wh.ChunkID.length, wh.ChunkID);
			
			fin.read(wh.ChunkSize); //ChunkSize
			System.out.print(wh.RIFF_NAME[1]+" : ");
			System.out.println(int_Data(wh.ChunkSize) + "B");
			
			fin.read(wh.Format); //Format 
			System.out.print(wh.RIFF_NAME[2]+" : ");
			showChar(wh.Format.length, wh.Format);
			
			//-------------------------------------------------------------------------
			
			System.out.println("\n[ Wave FMT Header ] 해석");
			fin.read(wh.fmt_chunkID); //fmt
			System.out.print(wh.FMT_NAME[0]+" : ");
			showChar(wh.fmt_chunkID.length, wh.fmt_chunkID);
			
			fin.read(wh.fmt_chunkSize); //fmt_chunkSize
			System.out.print(wh.FMT_NAME[1]+" : ");
			System.out.println(int_Data(wh.fmt_chunkSize) + "B");
			
			fin.read(wh.audio_format); //audio_format
			System.out.print(wh.FMT_NAME[2]+" : ");
			System.out.println(short_Data(wh.audio_format));
			
			fin.read(wh.num_channels); //num_channels 
			System.out.print(wh.FMT_NAME[3]+" : ");
			System.out.println(short_Data(wh.num_channels));
			
			fin.read(wh.sample_rate); //sample_rate
			System.out.print(wh.FMT_NAME[4]+" : ");
			System.out.println(int_Data(wh.sample_rate) + "Hz");
			
			fin.read(wh.byte_rate); //byte_rate
			System.out.print(wh.FMT_NAME[5]+" ");
			System.out.println(int_Data(wh.byte_rate) + "B");
			
			fin.read(wh.block_align); //block_align 
			System.out.print(wh.FMT_NAME[6]+" : ");
			System.out.println(short_Data(wh.block_align));
			
			fin.read(wh.pit_per_sample); //pit_per_sample  
			System.out.print(wh.FMT_NAME[7]+" : ");
			System.out.println(short_Data(wh.pit_per_sample));
			
			//--------------------------------------------------------------------------
			
			System.out.println("\n[ Wave DATA Header ] 해석");
			fin.read(wh.data_chunkID); //data_chunkID
			System.out.print(wh.DATA_NAME[0]+" : ");
			showChar(int_byte.length, wh.data_chunkID);
			
			fin.read(wh.data_chunkSize); //data_chunkSize
			System.out.print(wh.DATA_NAME[1]+" : ");
			System.out.println(int_Data(wh.data_chunkSize) + "B");
			
			fin.close();
		}catch(IOException e) {
			System.out.println("파일 읽기 실패!");
			return;
		}
	}

}
