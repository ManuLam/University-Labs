//: version "2.0-b10"
//: property encoding = "iso8859-1"
//: property locale = "en"
//: property prefix = "_GG"
//: property timingViolationMode = 2
//: property initTime = "0 ns"

`timescale 1ns/1ns

//: /netlistBegin main
module main;    //: root_module
reg w6;    //: /sn:0 {0}(253,251)(240,251)(240,269){1}
//: {2}(242,271)(431,271)(431,254)(448,254){3}
//: {4}(240,273)(240,367){5}
reg w0;    //: /sn:0 {0}(113,175)(187,175){1}
reg w1;    //: /sn:0 {0}(113,241)(187,241){1}
reg w2;    //: /sn:0 {0}(185,310)(169,310)(169,307){1}
//: {2}(171,305)(185,305){3}
//: {4}(167,305)(153,305){5}
//: {6}(151,303)(151,256)(151,256)(151,248){7}
//: {8}(153,246)(187,246){9}
//: {10}(151,244)(151,180)(187,180){11}
//: {12}(149,305)(130,305)(130,305)(112,305){13}
//: {14}(151,307)(151,322)(151,322)(151,376){15}
wire w16;    //: /sn:0 {0}(255,180)(230,180)(230,180)(208,180){1}
wire w3;    //: /sn:0 {0}(469,249)(476,249){1}
//: {2}(480,249)(508,249){3}
//: {4}(512,249)(529,249){5}
//: {6}(510,247)(510,207)(441,207)(441,191)(449,191){7}
//: {8}(478,247)(478,164)(166,164)(166,185)(187,185){9}
wire w21;    //: /sn:0 {0}(394,186)(449,186){1}
wire w20;    //: /sn:0 {0}(392,249)(448,249){1}
wire w8;    //: /sn:0 {0}(470,189)(486,189){1}
//: {2}(490,189)(497,189){3}
//: {4}(501,189)(528,189){5}
//: {6}(499,187)(499,170){7}
//: {8}(499,191)(499,237)(441,237)(441,244)(448,244){9}
//: {10}(488,191)(488,279)(175,279)(175,251)(187,251){11}
wire w11;    //: /sn:0 {0}(274,246)(297,246){1}
//: {2}(301,246)(371,246){3}
//: {4}(299,244)(299,229)(241,229)(241,185)(255,185){5}
wire w10;    //: /sn:0 {0}(208,246)(253,246){1}
wire w13;    //: /sn:0 {0}(206,308)(303,308){1}
//: {2}(307,308)(349,308)(349,253){3}
//: {4}(351,251)(371,251){5}
//: {6}(349,249)(349,188)(373,188){7}
//: {8}(305,310)(305,323){9}
wire w5;    //: /sn:0 {0}(253,241)(226,241)(226,217)(323,217)(323,185){1}
//: {2}(325,183)(373,183){3}
//: {4}(323,181)(323,128){5}
//: {6}(321,183)(276,183){7}
//: enddecls

  //: LED g4 (w13) @(305,330) /sn:0 /R:2 /w:[ 9 ] /type:0
  _GGNAND3 #(6) g8 (.I0(w0), .I1(w2), .I2(w3), .Z(w16));   //: @(198,180) /sn:0 /w:[ 1 11 9 1 ]
  //: joint g13 (w2) @(151, 246) /w:[ 8 10 -1 7 ]
  //: comment g3 @(123,156) /sn:0
  //: /line:"J"
  //: /end
  //: SWITCH g2 (w2) @(95,305) /sn:0 /w:[ 13 ] /st:1 /dn:1
  //: SWITCH g1 (w1) @(96,241) /sn:0 /w:[ 0 ] /st:1 /dn:1
  //: joint g16 (w2) @(169, 305) /w:[ 2 -1 4 1 ]
  //: comment g11 @(112,321) /sn:0
  //: /line:"CLOCK"
  //: /end
  //: joint g28 (w3) @(510, 249) /w:[ 4 6 3 -1 ]
  //: comment g10 @(122,224) /sn:0
  //: /line:"K"
  //: /end
  //: comment g32 @(263,387) /sn:0
  //: /line:"RESET"
  //: /end
  //: joint g27 (w3) @(478, 249) /w:[ 2 8 1 -1 ]
  _GGNAND2 #(4) g19 (.I0(w5), .I1(w13), .Z(w21));   //: @(384,186) /sn:0 /w:[ 3 7 0 ]
  //: LED g6 (w2) @(151,383) /sn:0 /R:2 /w:[ 15 ] /type:0
  _GGNAND3 #(6) g9 (.I0(w1), .I1(w2), .I2(w8), .Z(w10));   //: @(198,246) /sn:0 /w:[ 1 9 11 0 ]
  _GGNAND2 #(4) g7 (.I0(w2), .I1(w2), .Z(w13));   //: @(196,308) /sn:0 /w:[ 3 0 0 ]
  //: joint g31 (w11) @(299, 246) /w:[ 2 4 1 -1 ]
  _GGNAND2 #(4) g20 (.I0(w11), .I1(w13), .Z(w20));   //: @(382,249) /sn:0 /w:[ 3 5 0 ]
  //: SWITCH g15 (w6) @(240,381) /sn:0 /R:1 /w:[ 5 ] /st:1 /dn:1
  //: joint g29 (w8) @(488, 189) /w:[ 2 -1 1 10 ]
  //: joint g25 (w13) @(305, 308) /w:[ 2 -1 1 8 ]
  _GGNAND3 #(6) g17 (.I0(w5), .I1(w10), .I2(w6), .Z(w11));   //: @(264,246) /sn:0 /w:[ 0 1 0 0 ]
  //: LED g14 (w8) @(499,163) /sn:0 /w:[ 7 ] /type:0
  //: LED g5 (w5) @(323,121) /sn:0 /w:[ 5 ] /type:0
  //: joint g24 (w8) @(499, 189) /w:[ 4 6 3 8 ]
  _GGNAND2 #(4) g21 (.I0(w21), .I1(w3), .Z(w8));   //: @(460,189) /sn:0 /w:[ 1 7 0 ]
  //: joint g23 (w5) @(323, 183) /w:[ 2 4 6 1 ]
  //: joint g26 (w13) @(349, 251) /w:[ 4 6 -1 3 ]
  _GGNAND3 #(6) g22 (.I0(w8), .I1(w20), .I2(w6), .Z(w3));   //: @(459,249) /sn:0 /w:[ 9 1 3 0 ]
  //: SWITCH g0 (w0) @(96,175) /sn:0 /w:[ 0 ] /st:0 /dn:1
  _GGNAND2 #(4) g18 (.I0(w16), .I1(w11), .Z(w5));   //: @(266,183) /sn:0 /w:[ 0 5 7 ]
  //: joint g12 (w2) @(151, 305) /w:[ 5 6 12 14 ]
  //: joint g30 (w6) @(240, 271) /w:[ 2 1 -1 4 ]

endmodule
//: /netlistEnd

