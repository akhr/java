package com.akh.java_concepts_test.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTest {

	public static void main(String[] args){
		
		List<Pattern> compiledPatternsList = new ArrayList<>();
//		compiledPatternsList.add(Pattern.compile("([@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"));
		compiledPatternsList.add(Pattern.compile("([!-\\/:-@\\[-`{-~]{3})"));
		
		Map<Pattern, Integer> compiledPatternsMap =  new LinkedHashMap<>();
		// ([@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   {3})
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|<>\\/?]     =6
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   =10
		// ([.,])=6

		compiledPatternsMap.put(Pattern.compile("[!-+:-@\\[-`{-~\\/\\-]"), 6);
		compiledPatternsMap.put(Pattern.compile("([.,])"), 6);
		compiledPatternsMap.put(Pattern.compile("[!-\\/:-@\\[-`{-~]"), 10);
		
		List<String> escapedAddr = new ArrayList<>();
		int gibberishCount = 0;
		
		for(String address : getGibExamples_Quick()){
			boolean isGib = matchesGibberishPatterns(address, compiledPatternsList, compiledPatternsMap);
			System.out.println("Addr :: "+address+" - Is Gib - "+isGib+"\n");
			
			if (isGib){
				gibberishCount++;
			}else {
				escapedAddr.add(address);
			}
		}
		
		System.out.println("\n\nSample Size-"+getGibExamples_Quick().size());
		System.out.println("Gibberish Count-"+gibberishCount);
		System.out.println("Escaped Count-"+escapedAddr.size());
		System.out.println("\n\nEscaped Addresses : ");
		for (String str : escapedAddr)
		{ 		      
			System.out.println(str); 		
		}

	}


	private static boolean matchesGibberishPatterns(String address,
			List<Pattern> exactMatchPatternList,
			Map<Pattern, Integer> charThresholdPatternMap) {

		for(Pattern pattern: exactMatchPatternList) {
			if (matchesExactGibberishPattern(address, pattern))
				return true;
		}

		Set<Entry<Pattern, Integer>> patternsMap = charThresholdPatternMap.entrySet();
		Iterator<Entry<Pattern, Integer>> iterator = patternsMap.iterator();
		while(iterator.hasNext()){
			Entry<Pattern, Integer> entry = iterator.next();
			if (exceedsGibberishCharThreshold(address, entry.getKey(), entry.getValue()))
				return true;
		}

		return false;
	}
	
	public static boolean exceedsGibberishCharThreshold(String address, Pattern pattern, int threshold){
		Matcher m = pattern.matcher(address);
		int count = 0;
		while(m.find()){
			count++;
		}
		if (count >= threshold) {
			System.out.println("Exceed Thr : "+pattern.pattern()+" thrs - "+threshold);
			return true;
		} 
		return false;
	}

	public static boolean matchesExactGibberishPattern(String address, Pattern pattern){
		Matcher m = pattern.matcher(address);
		if (m.find()) {
			System.out.println("Matched Pattern : "+pattern.pattern());
			return true;
		} 
		return false;
	}



	public static List<String> getGibExamples_Quick(){
		ArrayList<String> arr = new ArrayList<String>(
				Arrays.asList(
						"8....34---6 N@@@&&&&&@&&@W 66TH,,, S...T",
						"8..95,,2 N@@W 2@4th Te-rra-ce",
						"7672 Dixon rd @@@@@@@@@@198",
						"(*&&(*&*(",
						"7672 ^& &^ $ ()Dixon rd @ @ @ @ @ @ @ @ @ @198",
						"{121}, ",
						"a bc d e ff 1 23 44"));
		return arr;
	}

	public static List<String> getGibExamples(){
		ArrayList<String> arr = new ArrayList<String>(
				Arrays.asList(
						"1.2.3.4.5.6.7.8.9.10",
						"8585 Spicewood Springs @@553",
						"173 W. Election Rd., eBay, Inc.",
						"7672 Dixon rd @@@@@@@@@@198",
						"(*&&(*&*(",
						"7672 ^& &^ $ ()Dixon rd @ @ @ @ @ @ @ @ @ @198",
						"{121}, ",
						"a bc d e ff 1 23 44",
						"#221,6720--158 Avenue",
						"#221,6720--158 Avenue",
						"#68--999 Burnaby Ave.",
						" 3350 Dovera Dr St 3149...",
						"-((85,50))- n,W 7)0th,s,t 348@2@5",
						"-((85,50))- n,W 7)0th,s,t 348@2@5",
						"-((85,50))- n,w 7,0t)h St34@8@25",
						"-(85,50)- n,w 7-0t,h s,t-34@8@25",
						"-(85,50)- n,w 70(t@h s@t34825",
						"-(85,50)- n,W 70)th s,t-34@8@25",
						"-(85,50)- n,w 70)th s,t-3@48@25",
						"--------",
						"---------16 Brimmond Place--------------",
						"...",
						"...",
						"....",
						".....1.3  C.o.as.t Ln",
						".....362 Sagewood Ln",
						"...4321......... Turtle Creek ...Dr...",
						"...9930 Thresher Ct",
						"...bitte unter dem CARPORT abstellen",
						"...PO Box 29...",
						"..8.3.4.6... nooorth w 6-6..,th st",
						".9.9.3.0. T.h.r.e.s.h.e.r. .C.t.........",
						"/21.4.3//  NW 79 A...ve",
						"0302otisellis@gmail.com",
						"1---14;;6-9 N@@W 34@@TH S..T",
						"1--1--46@@9 N@@W 34--TH S..T",
						"1--1..46..9 N@@W 34//TH S..T",
						"1--14--6..9 N@@W 34@@TH S..T",
						"1--14--6..9 N@@W 34@@TH S.T",
						"1--14--69 N@@W 34@@TH S..T",
						"1--14..6..9 N--W 34..TH S--T",
						"1--14..6..9 N@@W 34@@TH S..T",
						"1--146--9 N--W 34---TH S..T",
						"1--146--9 N@@W 34@@TH S..T",
						"1--14@@69 N@@W 34--TH S-T",
						"1...8...6  War.wick, st",
						"1...8..6 W.arwick st",
						"1..1..46@@9 N--W 34@@TH S@@T",
						"1..14,,6,,9 N@@W 34@@TH S..T",
						"1..14,,6..9 N---W 34@@TH S--T",
						"1..14,,6..9 N@@W 34---TH S@@T",
						"1..14,,6..9 N@@W 34@@TH S...T",
						"1..14,,69 N@@W 34--TH S-T",
						"1..14,,69 N@@W 34@@TH S..T",
						"1..14//6,,9 N--W 34--TH S..T",
						"1..146,,9 N@@W 34@@TH S..T",
						"1..14@@69 N--W 34@@TH S@@T",
						"1.3.. C.o.a.s.t.... Ln",
						"1.3... C.o.a.s.t.. Ln",
						"1.3... C.o.a.s.t... L.n",
						"1.8.9.0 North 82,nd AVE----Gis11864",
						"1.8.9.0 north n.w 82,nd Ave--11864",
						"1093 Cr. 145 -- USPS  or   UPS/FEDEX",
						"1156 W STONERIDGE CT APT...C",
						"11853 Gunston@Whithorn",
						"119 BEAUCHAMP ROAD...",
						"119 BEAUCHAMP ROAD...",
						"12 Church Lane...Hindolveston",
						"121 E Buell Street @po Box 332",
						"1220 se 1st ave, ---",
						"13... ...Coast.. Ln...",
						"13282 CR 45 ........  #304",
						"1345 nw 98th court...unit 2",
						"142....8572 nw 72 st gbs-1089",
						"14louchy@gmail.com",
						"150 Regina Dr S@UTH",
						"151 Hawk Hill Rd ---  Log House",
						"1603 NW.... 79th Ave",
						"16256885@qq.com",
						"16350 S. Harbor blvd unit 1306 Please deliver to Management Office with Attn: James @1306 Posted on the package.   :)",
						"1750 NORTH BROADWAY ST.--35",
						"18@90 N@W@ 82nd A@VE",
						"18@90 N@W@ 82nd A@VE",
						"19 Admiral House...Flat 1053...",
						"1912 e. Shelby rd., ---",
						"1912 e. Shelby rd., ---",
						"1=--14--6.9 N@@W 34@@TH S..T",
						"1@2 Heath Ave",
						"1@@14@@69 N---W 34@@TH S...T",
						"1agj08@gmail.com",
						"1connormcdougall@gmail.com",
						"1john3@telus.net",
						"2 ...1.4 3 N,wW 7/..9 Ave.SP,003439/,",
						"2 1 4 3 north.w 79 ave...LP/SP3240",
						"2,,,1four....3 noo-we3sst 79-th ave",
						"2,,0ne...four-3...no..WE 7/9 ave",
						"2....../1....4(3...avenue.79..th",
						"2.....1...4..3,,,nw 7,9th sy",
						"2...1...4...3...noort..we 79-th av",
						"2...1..4///3 NW 79 Ave",
						"2..1...4//.3 NW 79th Ave",
						"2.1.4..3 Norrthh W.... 79 Avenue",
						"2/1/4/3...NW 79 Ave",
						"202 -- 1340 Tecumseh Rd.,West.",
						"204 S.Hwy.59 <---UPS",
						"206 Park Street 2@ floor # 7",
						"21....43---N,,,W 79th==ave",
						"21...43 NnnnWwww 7,9 AVEeeee",
						"21...43 Nor.t../Wees 79 a.v",
						"21...43..nortW...79thAvenn",
						"214 Elm St...P.o. Box 283",
						"2143 NW // 79th Hh /56/Av/123/ e {@}¥",
						"2143...nwwe 79th av",
						"216 @ 261 hastings east",
						"21:4;-3 Nn,W 79@Ttth A3vee..",
						"21@43 N@W@ 79th A@VE",
						"21@43 N@W@ 79th A@VE",
						"22--H-20 Royal Town",
						"2508 TICE CREEK DRIVE @2",
						"2508 TICE CREEK DRIVE @2",
						"279 @ 56 GloucesterRd",
						"2931 CENTRAL @ PAISANO PMB # 373",
						"2931 CENTRAL @ PAISANO PMB # 373",
						"2931 Central Ave @ paisano  s111",
						"3.4.7.....wa.sh.ington..pl",
						"30... E46 Gerald St",
						"30... E46 Gerald St",
						"30... E46 Gerald St",
						"30... E46 Gerald St",
						"302 kansas street--/--p.o.box 302",
						"304-- 79  Thorncliffe Park Dr",
						"32 Narrung road gym @ football club",
						"324 C,,ro,,sb--y A,.-v--e",
						"338 Columbia Ave.--P.O. Box 318",
						"35 @ last",
						"372 Industrial Park Dr ---- PO BOX 287",
						"3941 Saratoga Ave Unit F--103",
						"3986 Fruitwood Ave   UNIT--B",
						"3A...buzzer no 10 Blithfield House Rickerscote",
						"4 The Old Gardens --",
						"4108 W 8th Ave--BOX 7",
						"43 Exeter Rd @ Clement Av",
						"45403--8th st. east",
						"4554 Ryan Pl...... Unit.C",
						"4554 Ryan Pl...... Unit.C",
						"4554 Ryan Pl...... Unit.C",
						"4800 Avenue @ port imperial",
						"496 east 161 street ---- apt#2A",
						"496 east 161 street ---- apt#2A",
						"5 humphries gnds-----",
						"5085 Avala Park Ln@@",
						"5085 Avala Park Ln@@@@",
						"5085 Avala Park Ln@@@@",
						"5182 Liberty AV @10184",
						"520 east 156 st apt---- #5H",
						"525 S. Center St. --2020",
						"53 spencer...po box 933",
						"532 hastings ave, jwoodworthp@aol.com",
						"54918@paradecollege.vic.edu.au",
						"555 S Argyle Ave @114",
						"56-75 64th St ...Apt 3E",
						"57 MAES TY CANOL....",
						"6 Sinaran Drive, Soleil@Sinaran #23-10",
						"6-ferry-lane--northkyme",
						"6/930, nort e.... W 12th stree... 8289.",
						"607 MOHAVE ST---BOX 1224",
						"607 MOHAVE ST---BOX 1224",
						"607 MOHAVE ST---BOX 1224",
						"6168@student.bmg.vic.edu.au",
						"6531 NW 87th Ave Ste T--13541",
						"6531 NW 87th Ave Ste T--14852",
						"6691 W@ildwood Trail",
						"66th,,st--8020...nw",
						"6930 NW 12Th St.;,...,.,..qws",
						"6930. N...W .12//T//h .,.,St 26627",
						"7--callerton avenue",
						"7030, Northstar@AMK",
						"7052 Christopher Dr...",
						"7052 Christopher Dr...",
						"709 Pinsonfork Rd@po box 6",
						"725 west main street--p.o. box593",
						"725 west main street--p.o. box593",
						"725 west main street--p.o. box593",
						"7314 South Lowe Ave...",
						"744 N. Somerton Ave--2288",
						"78--4TH AVE. #6",
						"78/42...N.W 46 ST",
						"79....//75 NW 21St",
						"8 3,5.2 N...N,W 24th, st,,,2885",
						"8 max place... Motala heights... Pinetown 3610",
						"8 S Michigan Ave---Secuity at Lobby",
						"8 S Michigan Ave---Secuity at Lobby",
						"8,.5,5.0 n.,w 7O,.th s.t rp\38824..--",
						"8,29,8---,--((NW,, 68th,St))",
						"8,29,8---,--((NW,, 68th,St))",
						"8,29,8---,--((NW,, 68th,St))CR",
						"8,37,2---,--((NW,, 68th,St))",
						"8,37,2---,--((NW,, 68th,St))",
						"8,5,72 North,West 72 t.h St--- #2989",
						"8,5.5,0 n.,w 70,th. s,t Xp/57190..--",
						"8,5.5,0 n.,w 70,th. s,t Xp/57190..--",
						"8,5.5,0 n.,w 70,th. s,t xp/57360..--",
						"8,5.5,0 n.,w 70,th. s,t xp/57456..--",
						"8,5.5,0 n.,w 70,th. s,t xp/57456..--",
						"8,5.5,0 n.,w 70,th. s,t xp/58482..--",
						"8,5.5,0 n.,w 70,th. s,t xp/58482..--",
						"8,5.5,0 n.,w 70,th. s,t xp/58677..--",
						"8,55,0--,--((NW,, 68th,St))##",
						"8,55,0---,--((NW,, 68th,St))",
						"8,9.5,2 n,.w 24,th.t,e,r XP/1600873..--",
						"8-0@20 N.W 6.6/t...h S...t",
						"8....37---2 N@@@W 68TH,,,S...T",
						"8....37---2 N@@@W 68TH,,,S...T",
						"8...3.72 N..,n.W 6...8,t.h St",
						"8...5...50 N.W 70,th S..T",
						"8..3.,46 N...n,w 6...6 ,th, st—-3073",
						"8..3..46 N...n,w 6...6 ,th, st---3073",
						"8..3..46 N...n,w 6...6 ,th, St---3084",
						"8..3..46 N...n,w 6...6 ,th, St---3084",
						"8..3..46 n...n,w 6...6 ,th, st---3085",
						"8..3..46 N...n,w 6...6,th, St---3080",
						"8..3..46 N...n,w 6...6,th, St---3080",
						"8..3..46 N...n,w 6...6,th, St---3080",
						"8..3..46 n...n,w 66 ,th, st---3085",
						"8..3..7..2 N..W 6..8t..h ....S..t",
						"8..3..72 N...n,W 6...8,th, St---15028",
						"8..3.72 N..,n,W 6...8 ,th, St---13936",
						"8..3.72 N..,n,W 6...8 ,th, St---15028",
						"8..3.72 N..,n,W 6...8 ,th, St---15028",
						"8..3.72 N..,n.W 6...8.t.h St",
						"8..4.2.4..nw..56th...st",
						"8..5..50...n..,..,w.....70thhh,,, st.,@",
						"8..5..72 N...n,w 7...2,th, St---2980",
						"8..95,,2 N--W 24@@th Te@@rra@@ce",
						"8..95,,2 N-W 24--th Te@rra@ce",
						"8.0.02 Nort N,W 66,th, St---010160",
						"8.0.2.0 north N,w 66,th St---011216",
						"8.5,5.0 n.,w 70,th s.t rp\57844..--",
						"8.5,7,2  N.W 72 ,th,St--- #2989",
						"8.5,7,2 N,,W 7.2 S.....t #,,,2989",
						"8.5,7,2 N.W 72 ,th,St ---#2989",
						"8.5,7....2 North.West... 72 St ---#2989",
						"8.5,72 North,West 7.2 th St... #2989",
						"8.5,72 North.West 72. th St... #2989",
						"8.5.,5.0 n,w 7,0\t.h s.,t xp\57905..--",
						"8.5.,5.0 n,w 7,0\t.h s.,t xp\57905..--",
						"8.5.5.0 n.w,70th.s.t,suite/54995.,--",
						"8.5.5.0 n.w,70th.s.t,suite/54995.,--",
						"8.5.5/0 N...W. 7.0t/h S/T",
						"8.5.50...,n.w,,70/th..s.t.,",
						"8.5.50...,n.w,,70/th..s.t.,",
						"8.5.7 2 North N,W 72,th, St---2991",
						"8.5.72  N,W 72,th, St---2980",
						"8.5.72 North N,W 72,th, St-- 2980",
						"8.5.72 North N,W 72,th, St---2816",
						"8.5.72 North N,W 72,th, St---2980",
						"8.5.72 North N,W 72,TH,St--1216",
						"8.5.72 North N.W 72,th, St--- #2989",
						"8.5.72 North.West 72 ,th St--- #2989",
						"8.55..0 N-W 7--0th S..T",
						"8.57,2 North.West 7.2 ,th---St #2989",
						"8/74--76 wangee rd lakemba",
						"8/@@37#2..nw,,6/8 thhh sttt..",
						"80,20...NW/66th,,,St---apt 2942",
						"800 S.W Green Oaks Blvd. @Matlock, Suite 302",
						"8020 NW 66...th St",
						"8023 nw 66th st-/....,.",
						"806 -- 82 Queens Rd",
						"80x 20 NortW 66...th St",
						"80x 20 NW 66...th St",
						"813 Greeley St. --Box 606",
						"818 Mansfield Dr Unit 286................",
						"82,98--,---[NW'68,th'ST]!!",
						"82,98--,---[NW'68,th'ST]!!",
						"82,98--,---[NW'68,th'ST]!!",
						"82,98--,---[NW'68,th'ST]!!",
						"82,98--,---[NW'68,th'ST]!!)",
						"82,98--,---[NW'68,th'ST]!!)",
						"82,98--,--[NW'68,th'st]!!",
						"82.98//---'NW.!,,68th-ST!!--",
						"82.98//---'NW.!,,68th-ST!!--",
						"82@98 NW$ 68#th St,",
						"82th• _4747...2775NW. AVE_",
						"83....46--- N,,,W 66th==st,dee-1409",
						"83....46--- n,,,w 66th==st,dee1410",
						"83...46-- n,,,w 66th=,st,dee141o",
						"83..46 N...n,w 6...6 ,th, St---3084",
						"8346 N.W. 66....th St  ACS 3298",
						"8346,,,,N....N...W 6,,6,,TH,,,,3426",
						"8372---- NW ----68th ----St",
						"8372---- NW ----68th ----St",
						"85,50--,---[NW'70,th'ST]!!",
						"85,50--,---[NW'70,th'ST]!!",
						"85,50--,---[NW'70,th'ST]!!",
						"85,7,,2 North,West 72th, St--#2980",
						"85--_--5O_N.-- .W¯7O--_h_ST",
						"85--_--5O_N.-- .W¯7O--_h_ST",
						"85....5-0 NW 7/0th S-t",
						"855-0 N...W 70th State",
						"8550, n...nw 7,,,0,th,,, st.35006",
						"857 Broadway, 4th Floor -- Ring Bell #4",
						"85_--_50 _NW ~\"70_-_th} ST",
						"85_--_50 _NW ~\"70_-_th} ST",
						"8610...../NW....72nd...../St",
						"880 anthony creek rd...",
						"880 anthony creek rd...",
						"880 anthony creek rd...",
						"8952. NW. 24th. Terrace @1619189",
						"8952. NW.. 24.th. Terrace @1619189",
						"8952. NW.. 24th. Terrace @1619189",
						"8952. NW.. 24th. Terrace. @1619189",
						"8952. NW.. 24th.. Terrace @1619189",
						"8@3.4.6 NbgWesc 6.6th St",
						"8@@372 nw!/# 68/:, thhh sttt.@",
						"906 Main St  (Back Porch)........",
						"9438 nw 13th st. Bay # 58, Doral, FL. 33172 optimacargo@gmail.com",
						"9438 nw 13th st. Bay # 58, Doral, FL. 33172 optimacargo@gmail.com",
						"95 Coyote Cir...195",
						"95 Coyote Cir...195",
						"95 Coyote Cir...195",
						"950 North Kings Rd @213",
						"@ Crystal Shores East,  549 Lakeshore Blvd",
						"@ Gavs Bikes",
						"@ GOULD Barbers",
						"@ Happy Jack Lodge and RV Park",
						"@ Jax Tyres",
						"@ Meridian Implement",
						"@ natural complexions",
						"@ Northbrook Manor Care Center",
						"@ White star tattoo",
						"@8---3@7@2@ n///...w 6,8th//.,tt/,",
						"@8372@., n@w 6,8--th st@,",
						"@8372@@/ n@w 6,8--th st./@",
						"@8372@@// nww/w 6,8 /th sttt.,",
						"@83@@72@@// n,/.w 6,8--th sttt",
						"@83@@7@2@@ n@/w 6,8.tttthhh sst@,",
						"@@6930 NW 12th ST@",
						"@@83//72//@@/ n,./w 6,8--th st@,",
						"@ACH porsche cars",
						"@Compu-Tech 29a Queen Street",
						"@Jessie’s (At the Beach",
						"@Lashes",
						"@Lt. Brown House",
						"@Vinyl Flip USA",
						"C street # D--3  El  Dorado",
						"C/ O Allansford post office....1/366 Staffords Road",
						"C/ O Allansford post office....1/366 Staffords Road",
						"c/o 2102 -- 12 Avenue South",
						"c/o Sue Stroud @Eastgates",
						"C25-10@Shamelin Star, No 36 A,",
						"C25-10@Shamelin Star, No 36 A,",
						"C4DI @TheDock",
						"flat 1--622 new chester road,rock ferry",
						"Flat 1...102 Seabank Road",
						"Flat 1...102 Seabank Road",
						"Flat 1...102 Seabank Road",
						"flat 22---   49 hallam street",
						"flat @ 13 george street",
						"Flat B (@Back of House)",
						"flat one....Ardingly court",
						"flat one....Ardingly court",
						"X...8952 NW 24th Terr  ,voz,1623238",
						"X...8952 NW 24th Terr  ,voz,1623238"));

		return arr;

	}

	//	if (matchExactPattern(address)){
	//		gibberishCount++;
	//		continue;
	//	}
	//
	//	int count = 0;
	//	Matcher m = r.matcher(address);       
	//	while(m.find()){
	//		count++;
	//	}
	//	if (count >= 5) {
	//		gibberishCount++;
	//		System.out.println("Count: "+address+" --> "+count+" Is Gibberish --> "+true);
	//	} else {
	//		escapedAddr.add(address);
	//		System.out.println("*** Count: "+address+" --> "+count+" Is Gibberish --> "+false);
	//	}
}
