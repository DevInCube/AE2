package temp;

public class ByteErrors {
	
	/***
	 * Retreiving online news thread run() error (Game)
	 */
	
	// Byte code:
	// 0: aconst_null
	// 1: astore_1
	// 2: aconst_null
	// 3: astore_2
	// 4: aload_0
	// 5: getfield 138 Class_i_168:var_3c5b Ljava/io/ByteArrayOutputStream;
	// 8: invokevirtual 704 java/io/ByteArrayOutputStream:toByteArray ()[B
	// 11: astore_3
	// 12: aload_0
	// 13: getfield 138 Class_i_168:var_3c5b Ljava/io/ByteArrayOutputStream;
	// 16: invokevirtual 625 java/io/ByteArrayOutputStream:close ()V
	// 19: aload_0
	// 20: getfield 139 Class_i_168:var_3c63 Ljava/io/DataOutputStream;
	// 23: invokevirtual 624 java/io/DataOutputStream:close ()V
	// 26: aload_0
	// 27: getfield 267 Class_i_168:var_3c53 Ljava/lang/String;
	// 30: invokestatic 679 javax/microedition/io/Connector:open
	// (Ljava/lang/String;)Ljavax/microedition/io/Connection;
	// 33: checkcast 34 javax/microedition/io/HttpConnection
	// 36: astore_2
	// 37: ldc_w 749
	// 40: invokevirtual 673 java/lang/String:length ()I
	// 43: ifle +47 -> 90
	// 46: ldc_w 749
	// 49: invokevirtual 664 java/lang/String:getBytes ()[B
	// 52: astore 4
	// 54: aload_0
	// 55: getfield 151 Class_i_168:var_3c6b I
	// 58: istore 5
	// 60: iload 5
	// 62: aload_3
	// 63: arraylength
	// 64: if_icmpge +26 -> 90
	// 67: aload_3
	// 68: iload 5
	// 70: dup2
	// 71: baload
	// 72: aload 4
	// 74: iload 5
	// 76: aload 4
	// 78: arraylength
	// 79: irem
	// 80: baload
	// 81: ixor
	// 82: i2b
	// 83: bastore
	// 84: iinc 5 1
	// 87: goto -27 -> 60
	// 90: aload_2
	// 91: ldc_w 752
	// 94: invokeinterface 723 2 0
	// 99: aload_2
	// 100: ldc_w 747
	// 103: aload_3
	// 104: arraylength
	// 105: invokestatic 706 java/lang/Integer:toString
	// (I)Ljava/lang/String;
	// 108: invokeinterface 724 3 0
	// 113: aload_2
	// 114: ldc_w 746
	// 117: ldc_w 766
	// 120: invokeinterface 724 3 0
	// 125: aload_2
	// 126: invokeinterface 722 1 0
	// 131: dup
	// 132: astore 4
	// 134: aload_3
	// 135: invokevirtual 712 java/io/OutputStream:write ([B)V
	// 138: aload 4
	// 140: invokevirtual 660 java/io/OutputStream:flush ()V
	// 143: aload 4
	// 145: invokevirtual 626 java/io/OutputStream:close ()V
	// 148: aload_2
	// 149: invokeinterface 721 1 0
	// 154: astore 5
	// 156: aload_2
	// 157: invokeinterface 720 1 0
	// 162: dup
	// 163: istore 6
	// 165: sipush 200
	// 168: if_icmpne +56 -> 224
	// 171: new 19 java/io/ByteArrayOutputStream
	// 174: dup
	// 175: invokespecial 444 java/io/ByteArrayOutputStream:<init> ()V
	// 178: astore 7
	// 180: iconst_0
	// 181: istore 8
	// 183: aload 5
	// 185: invokevirtual 685 java/io/DataInputStream:read ()I
	// 188: dup
	// 189: istore 8
	// 191: iconst_m1
	// 192: if_icmpeq +13 -> 205
	// 195: aload 7
	// 197: iload 8
	// 199: invokevirtual 713 java/io/ByteArrayOutputStream:write (I)V
	// 202: goto -19 -> 183
	// 205: aload 7
	// 207: invokevirtual 704 java/io/ByteArrayOutputStream:toByteArray ()[B
	// 210: astore_1
	// 211: aload 7
	// 213: invokevirtual 625 java/io/ByteArrayOutputStream:close ()V
	// 216: aload 5
	// 218: invokevirtual 623 java/io/DataInputStream:close ()V
	// 221: goto +32 -> 253
	// 224: new 23 java/lang/Exception
	// 227: dup
	// 228: new 28 java/lang/StringBuffer
	// 231: dup
	// 232: invokespecial 436 java/lang/StringBuffer:<init> ()V
	// 235: ldc_w 725
	// 238: invokevirtual 575 java/lang/StringBuffer:append
	// (Ljava/lang/String;)Ljava/lang/StringBuffer;
	// 241: iload 6
	// 243: invokevirtual 576 java/lang/StringBuffer:append
	// (I)Ljava/lang/StringBuffer;
	// 246: invokevirtual 705 java/lang/StringBuffer:toString
	// ()Ljava/lang/String;
	// 249: invokespecial 450 java/lang/Exception:<init>
	// (Ljava/lang/String;)V
	// 252: athrow
	// 253: aload_2
	// 254: ifnull +18 -> 272
	// 257: aload_2
	// 258: invokeinterface 719 1 0
	// 263: goto +9 -> 272
	// 266: dup
	// 267: astore 11
	// 269: invokevirtual 682 java/lang/Exception:printStackTrace ()V
	// 272: goto +54 -> 326
	// 275: dup
	// 276: astore_3
	// 277: invokevirtual 682 java/lang/Exception:printStackTrace ()V
	// 280: aload_2
	// 281: ifnull +18 -> 299
	// 284: aload_2
	// 285: invokeinterface 719 1 0
	// 290: goto +9 -> 299
	// 293: dup
	// 294: astore 11
	// 296: invokevirtual 682 java/lang/Exception:printStackTrace ()V
	// 299: goto +27 -> 326
	// 302: astore 9
	// 304: aload_2
	// 305: ifnull +18 -> 323
	// 308: aload_2
	// 309: invokeinterface 719 1 0
	// 314: goto +9 -> 323
	// 317: dup
	// 318: astore 11
	// 320: invokevirtual 682 java/lang/Exception:printStackTrace ()V
	// 323: aload 9
	// 325: athrow
	// 326: aload_0
	// 327: getfield 59 Class_i_168:var_3c73 Z
	// 330: ifne +8 -> 338
	// 333: aload_0
	// 334: aload_1
	// 335: invokevirtual 606 Class_i_168:sub_14cdb ([B)V
	// 338: return
	// Local variable table:
	// start length slot name signature
	// 0 339 0 this Class_i_168
	// 1 334 1 arrayOfByte byte[]
	// 3 306 2 localHttpConnection javax.microedition.io.HttpConnection
	// 11 266 3 localObject1 Object
	// 52 92 4 localObject2 Object
	// 58 27 5 i int
	// 154 63 5 localDataInputStream DataInputStream
	// 163 79 6 j int
	// 178 34 7 localByteArrayOutputStream ByteArrayOutputStream
	// 181 17 8 k int
	// 302 22 9 localObject3 Object
	// 267 52 11 localException1 Exception
	// 266 1 12 localException2 Exception
	// 275 1 13 localException3 Exception
	// 293 1 14 localException4 Exception
	// 317 1 15 localException5 Exception
	// Exception table:
	// from to target type
	// 257 263 266 java/lang/Exception
	// 4 253 275 java/lang/Exception
	// 284 290 293 java/lang/Exception
	// 4 253 302 finally
	// 275 280 302 finally
	// 302 304 302 finally
	// 308 314 317 java/lang/Exception
}
