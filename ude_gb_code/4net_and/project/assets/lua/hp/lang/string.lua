LJP   4  4   > =  T�4   @ T�H  G  numbertonumber	type` 
 4    >+  7 > T�' ' I�% 	 $	K�H �0lentostring� 	F  T$�2 4  +  7  ' ' >' > ;4  +  7  ' ' >' > ;4  +  7  ' ' >' > ;H T�4  +  7  ' ' >' > 4  +  7  ' ' >' > 4  +  7  ' ' >' > F G  �subtonumber�� 2    T�%    7  >* '  '	 I�6
 7% >  	  T�8+  78>9K�H �toNumber:
split � 9' 2  )  Q#�+  7    	 )
 >  T�T�+  7  	 
 >   T�+  7 > 4 7 	 >+  7 >T�+  7   >  T�+  7 > 4 7 	 >H �leninsert
tabletoNumbersub	find�  ,%    T�%   T�'   7 % >  T� 4 7 !> '  '	 I� 6
$ 	 T� 
 T�   $T� % $K�H 	ceil	math 
split# �    T�4  7' ' > +  7 >)  '   7 >' I�	  7 
 > +	  7		
 >	$	K�H �	bytelen	charrandom	math�� 
%    7 ' > '   7 >' I�  7 	 >5  +  74	 >$K�H �	charnewCharlen	byte�� 7   T�  T�G  '   +  7 +  7*  T	(�Q	'�	 
    >		 '  '	� 	 T	�'	� 	 T	�' T		�'	� 	 T	�' T	�'	� 	 T	�' 	 
     >
  >	 	 T
�T	� T	�G  �	bytesub   +      ,   G  �4 '  +  7   1 >0  �H � u8foreachV  +  +  T�, +  +  T�, T�) H +   ,  G  ������   T�  T�)  0 �  T�(   T�)  0 �' ' ' 1  +  7  	 >+  7  	 
 0  �@ H H �subu8foreach ��������:  +  7   % % >H �%1^%s*(.-)%s*$	gsub2   4  7  >  T�% H gbk2u8lc2   4  7  >  T�% H u82gbklc:  +  7 % +  7  > ?   	byte	%02XformatK    T�)  0 	�+  7   % 1 >  0  �H  H � (.)	gsub� ?   T�)  H '  '  2  4  75 +  75 +  75 '   ' I�4 	 4
 % +  74     > =  =
 = 	 T�4 	 %
	 >T�	 T�4 	 %

 >'  K�'   T�4  %
 >4  7 >  H  �concat
   	byte
%02X string_formatformatstring_subsubtable_insertinsert
table g    T�  T�)  H +  7    >  T�)  H +  7  '   @ �sub	findy   4  7> 7> 7  > 7> 7@ getHashHex
close
writeopenMD5newMOAIHashWriter�  ( .2   4    3 4 :>  1 :1 :1	 :1 :
1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1! : 1# :"1% :$1' :&0  �H   md5 	lsub dumpbuffer 
toHex u2a a2u 	trim 
u8sub 
u8len u8foreach decrypt encrypt splitToLines 
split toTable hexToRGB fromNumberWithZeros toNumber__indexstring  setmetatable 