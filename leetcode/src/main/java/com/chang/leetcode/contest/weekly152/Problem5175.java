package com.chang.leetcode.contest.weekly152;

import java.util.*;

public class Problem5175 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int len = s.length();
        int[][] diffs = new int[len][len];
        calDiffs(s, diffs);
        for(int[] comb : queries) {
            if(diffs[comb[0]][comb[1]] / 2 > comb[2]) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }

    private void calDiffs(String s, int[][] diffs) {
        int[] chars = new int[26];
        Arrays.fill(chars, 0);
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        int len = s.length();
        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int m = 0; m < chars.length; m++) {
                if(chars[m] % 2 != 0) {
                    count++;
                }
            }
            diffs[i][len - 1] = count;

            int[] tmp = Arrays.copyOf(chars, 26);
            for(int j = len - 1; j > i; j--) {
                if(tmp[s.charAt(j) - 'a'] % 2 == 0) {
                    diffs[i][j - 1] = diffs[i][j] + 1;
                } else {
                    diffs[i][j - 1] = diffs[i][j] - 1;
                }
                tmp[s.charAt(j) - 'a'] += 1;
            }

            chars[s.charAt(i) - 'a'] -= 1;
        }
    }


    public static void main(String[] args) {
        Problem5175 problem = new Problem5175();
        int[][] queries = new int[5][3];
        queries[0] = new int[]{3, 3, 0};
        queries[1] = new int[]{1, 2, 0};
        queries[2] = new int[]{0, 3, 1};
        queries[3] = new int[]{0, 3, 2};
        queries[4] = new int[]{0, 4, 1};
        List<Boolean> res = problem.canMakePaliQueries("abcda", queries);

        int[][] queries2 = new int[1][3];
        queries2[0] = new int[]{0, 3, 1};
        List<Boolean> res2 = problem.canMakePaliQueries("hunu", queries2);

        String s = "lybypsnwvozshezupkrubmrapgbsbininmjmjkbkjkvoxcpqrsvwfshmtulqrypyhofubmnylkrapqhgxgdofcvmrylqpejqbalahwryrkzavgdmdgtqpgpmjghexybyrgzczyhafcdqbgncrcbihkdmhunuzqrkzsnidwbunszulspmhwpazoxijwbqpapmretkborsrurgtinansnupotstmnkfcfavaxglyzebsbuxmtcfmtodclszghejevmhcvshclydqrulwbyhajgtargjctqvijshexyjcjcrepyzazexujqtsjebcnadahobwfuvirivwbkdijstyjgdahmtutavapazcdspcnolsvmlorqxazglyjqfmtclsfaxchgjavqrifqbkzspazwnczivetoxqjclwbwtibqvelwxsdazixefcvarevabmfabqfivodqfaluxqpcxwfkzyxabytijcnohgzgbchwpshwnufcvqfcnglshwpgxujwrylqzejmdubkxsbctsfwdelkdqzshupmrufyxklsjurevipyfobudkbgpqtadspgvinafefktctinyvgfkpurgrihwbkjsrybmnqrgnubufebatwberilmrejgzsbqpkdonytkbknstsxifofmrktcpqhklcrebcjipetgnmlqvijovmlgripwratarmtmvkpujoxebyvmjqbmbsrcvejqpodehsjingfetapqpypwrcjsjsfotqzcdmvmfinetotshixutorylcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmvabklgfivmpozinybwlovcnafqfybodkhabyrglsnenkbergfcfyzatglgdolydcxyfyrmjcxmrepqnulwjipqvqparqvqrgjqtehglapuxqbihovktgzgtijohgfabwbmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzqbmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgxopmtqvejqvudezchsloxizynabehqbyzknunobehkzqtktsrwbovohkvqhwrwvizebsrszcxepqrenilmvadqxuncpwhedknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxedulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqzwhydynkfslsrmvyhonyjenyrenojofafmnafmfyhyjebwhqpwhctqdkfctanypmxqxktqfwfgnwjqpsbgpydovufgfqbyvqpufujypcbmdupybalwpkbidypqbwhefijytypwdwbsharqdurkrslqlqlajodcpirubsryvudgpwncrmtypatunqpkhehuhkdmbctyxghsfktazkvwrkharmnqpwxyhejgvybifmncdorglsfqlidupyvcnypwvglormjirmdqnwnelyturkdobypezwvonqpubedetansrkjgzyzgpuxajgdajizelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvcrwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsjazopevefqpmvkvctwhgnivoxqlwrmfyrslyjqlufgxkponkbgpqtifyhgbgdsvqvkjmritatgzspyfwpozuzwpujqfctepatuponctwpejwzmbwzarojohergrwzsjgjmnwfwjyxyhafstetgbydobynmxabavodsfwbqbevozkjkpwvwpgrwlabutilctsrgbgxorwjezspgxwredqjklabwterwzyzstwpobwjujwjkbyvcxytipcbotezezipavebqxcbkxarahalozyhetotejkrehilazkzgbsngrmxcloxexmvqzmfcvunongdgxotqbirwlyxqfijwduhivclefufubetsvefotmvwhstufgfqlspqpidwrmjexifslkzobcjqvwlevghglynojchkvufqnwxixqnercbabmxuhadmbsbabqzirgrcxazcxypmjebgxyzmlepcdezwbsjkjalgdotcjavojehsvaxkbslkrchgpapizsxydmpcjmloxydgzmrujypqzsnmrspmjspwpczetwtctqrkxafktihwzupidotwrufgbiruzujyvaxypibobwnejcfohwnwtwnqjqzkpulklivgfmtctaxihchencvyjipqvgvsjapghwhmhqjclmpwrqfavchutgpajutqdiholadqnkpmpwdqbifqbunypwrsnyjerwzcjabufutofgbqnylglinkrubebaxuhmtobutovoxqlcvorypijudsfmzilqvsnilmjinmvmdohabuzyrorkbanijqfebkjydkxsvotanwpipypwjkxoxkdojctmlufqvshahytslodyhynoxglqdyjqbizidwhcdmjshobodgdytsbefaxmfczilgvslqlchgdmhslmjahcrevehypctavipchurmnqxwfubqryhcdmpyvuxslkpengranercjmrejcdmnodyrcdczehuhkrgxgxwzuxwpmloxkxanghalshgbqhwnmzmfwhafszirozoroxsxcpwbedqvuxujaxcfebwzghylytodqdaronqdmzgzyvqnixangpopidibchobmdspetqfgnaduvsdqrofazqlijulstufkpipydijwvwvwhylmbixevorifidopalcbobutkhabafmdavelsfejwhwdixqvqvcdoxypgxwpgvqhmdehensngpyjijyxkdyroxcpibgfmlibuxynulmnulaxoxyhsrmxifkxubwpizadmjobmdofazynoxsngxarqzapejmlelidsbuxkfgdkpaxotelsjgnwzgdkdkxinubehytirahinixidqnizyfclcjcdyjgvsjqjetclaxqpinodihmzubkbopmxenshejqhgbkhyrgbmjoxifcbslcrghizopkvonuhqdgtotkjijqfgxefknipklurolotqboduzubebwdmjmxmdozytidajmbcnydevclojqrmvanklyxyfqrktsxktafkhcvajolyvaxmnuhavcfobwlsbcnadgvmjmbunipavmvgpydobypabebilyfslalutklytypibijgrodofmtshajcnivmjkjklgxirolybqnmtsfslovstgjadszojufsbmpsnefodwzkzeretgpstkbivsbinsvghsfolutulszyxonwbubgdupmhidsvoruzchyritodwpahydqnmxktmpcdwngzqbalovalcrmribapk";
        int[][] queries3 = new int[1][3];
        queries3[0] = new int[]{1607, 1628, 10};
        List<Boolean> res3 = problem.canMakePaliQueries(s, queries3);
    }
}