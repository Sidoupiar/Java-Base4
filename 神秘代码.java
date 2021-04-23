public final class 神秘代码
{
	public static final void main( String[] args )
	{
		// 最终显示出来的字符集 , 也可以认为是密匙
		String code = "嗷呜熬~"; //♪♩♫♬|一二三四|∶∵∴∷
		// 原始字符串
		String source = "我们来看一下base4算法";
		
		System.out.println( "原始文本 : "+source );
		String encode = 神秘代码.encode( code , source.getBytes() , 0 , 0 );
		String decode = 神秘代码.decode( code , encode );
		System.out.println( "加密文本 : "+encode );
		System.out.println( "还原文本 : "+decode );
	}
	
	// 进行编码
	private static final String encode( String code , byte[] b , int start , int count )
	{
		String encode = "";
		int bs;
		for( int i = start , c = count>0 ? start+count : b.length ; i < c ; i ++ )
		{
			bs = b[i];
			encode += code.charAt( bs>>6&0x03 );
			encode += code.charAt( bs>>4&0x03 );
			encode += code.charAt( bs>>2&0x03 );
			encode += code.charAt( bs&0x03 );
		}
		return encode;
	}
	
	// 进行解码
	private static final String decode( String code , String encode )
	{
		byte[] b = new byte[encode.length()/4];
		for( int i = 0 , j = 0 , c = encode.length() ; i < c ; i += 4 , j ++ )
			b[j] = ( byte ) ( code.indexOf( encode.charAt( i ) ) << 6 & 0xC0
					| code.indexOf( encode.charAt( i+1 ) ) << 4 & 0x30
					| code.indexOf( encode.charAt( i+2 ) ) << 2 & 0x0C
					| code.indexOf( encode.charAt( i+3 ) ) & 0x03 );
		return new String( b );
	}
}
