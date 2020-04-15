/**
 * 1177. Can Make Palindrome from Substring
 * <p>
 * Given a string s, we make queries on substrings of s.
 * For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right],
 * and then choose up to k of them to replace with any lowercase English letter.
 * <p>
 * If the substring is possible to be a palindrome string after the operations above,
 * the result of the query is true. Otherwise, the result is false.
 * <p>
 * Return an array answer[], where answer[i] is the result of the i-th query queries[i].
 * <p>
 * Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2,
 * we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)
 * <p>
 * <p>
 * <p>
 * Example :
 * <p>
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0] : substring = "d", is palidrome.
 * queries[1] : substring = "bc", is not palidrome.
 * queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s only contains lowercase English letters.
 */
package com.chang.leetcode.contest.weekly152;

import java.util.*;

public class Problem1177 {

    // Memory Limit Exceeded
    public List<Boolean> canMakePaliQueriesTooBig(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int len = s.length();
        int[][] diffs = new int[len][len];
        calDiffs(s, diffs);
        for (int[] comb : queries) {
            if (diffs[comb[0]][comb[1]] / 2 > comb[2]) {
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
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int m = 0; m < chars.length; m++) {
                if (chars[m] % 2 != 0) {
                    count++;
                }
            }
            diffs[i][len - 1] = count;

            int[] tmp = Arrays.copyOf(chars, 26);
            for (int j = len - 1; j > i; j--) {
                if (tmp[s.charAt(j) - 'a'] % 2 == 0) {
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
        Problem1177 problem = new Problem1177();
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

        String s2 = "nwlybypsnwvozshezupkrubmrapgbsbininmjmjkbkjkvoxcpqrsvwfshmtulqrypyhofubmnylkrapqhgxgdofcvmrylqpejqbalahwryrkzavgdmdgtqpgpmjghexybyrgzczyhafcdqbgncrcbihkdmhunuzqrkzsnidwbunszulspmhwpazoxijwbqpapmretkborsrurgtinansnupotstmnkfcfavaxglyzebsbuxmtcfmtodclszghejevmhcvshclydqrulwbyhajgtargjctqvijshexyjcjcrepyzazexujqtsjebcnadahobwfuvirivwbkdijstyjgdahmtutavapazcdspcnolsvmlorqxazglyjqfmtclsfaxchgjavqrifqbkzspazwnczivetoxqjclwbwtibqvelwxsdazixefcvarevabmfabqfivodqfaluxqpcxwfkzyxabytijcnohgzgbchwpshwnufcvqfcnglshwpgxujwrylqzejmdubkxsbctsfwdelkdqzshupmrufyxklsjurevipyfobudkbgpqtadspgvinafefktctinyvgfkpurgrihwbkjsrybmnqrgnubufebatwberilmrejgzsbqpkdonytkbknstsxifofmrktcpqhklcrebcjipetgnmlqvijovmlgripwratarmtmvkpujoxebyvmjqbmbsrcvejqpodehsjingfetapqpypwrcjsjsfotqzcdmvmfinetotshixutorylcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmvabklgfivmpozinybwlovcnafqfybodkhabyrglsnenkbergfcfyzatglgdolydcxyfyrmjcxmrepqnulwjipqvqparqvqrgjqtehglapuxqbihovktgzgtijohgfabwbmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzqbmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgxopmtqvejqvudezchsloxizynabehqbyzknunobehkzqtktsrwbovohkvqhwrwvizebsrszcxepqrenilmvadqxuncpwhedknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxedulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqzwhydynkfslsrmvyhonyjenyrenojofafmnafmfyhyjebwhqpwhctqdkfctanypmxqxktqfwfgnwjqpsbgpydovufgfqbyvqpufujypcbmdupybalwpkbidypqbwhefijytypwdwbsharqdurkrslqlqlajodcpirubsryvudgpwncrmtypatunqpkhehuhkdmbctyxghsfktazkvwrkharmnqpwxyhejgvybifmncdorglsfqlidupyvcnypwvglormjirmdqnwnelyturkdobypezwvonqpubedetansrkjgzyzgpuxajgdajizelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvcrwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsjazopevefqpmvkvctwhgnivoxqlwrmfyrslyjqlufgxkponkbgpqtifyhgbgdsvqvkjmritatgzspyfwpozuzwpujqfctepatuponctwpejwzmbwzarojohergrwzsjgjmnwfwjyxyhafstetgbydobynmxabavodsfwbqbevozkjkpwvwpgrwlabutilctsrgbgxorwjezspgxwredqjklabwterwzyzstwpobwjujwjkbyvcxytipcbotezezipavebqxcbkxarahalozyhetotejkrehilazkzgbsngrmxcloxexmvqzmfcvunongdgxotqbirwlyxqfijwduhivclefufubetsvefotmvwhstufgfqlspqpidwrmjexifslkzobcjqvwlevghglynojchkvufqnwxixqnercbabmxuhadmbsbabqzirgrcxazcxypmjebgxyzmlepcdezwbsjkjalgdotcjavojehsvaxkbslkrchgpapizsxydmpcjmloxydgzmrujypqzsnmrspmjspwpczetwtctqrkxafktihwzupidotwrufgbiruzujyvaxypibobwnejcfohwnwtwnqjqzkpulklivgfmtctaxihchencvyjipqvgvsjapghwhmhqjclmpwrqfavchutgpajutqdiholadqnkpmpwdqbifqbunypwrsnyjerwzcjabufutofgbqnylglinkrubebaxuhmtobutovoxqlcvorypijudsfmzilqvsnilmjinmvmdohabuzyrorkbanijqfebkjydkxsvotanwpipypwjkxoxkdojctmlufqvshahytslodyhynoxglqdyjqbizidwhcdmjshobodgdytsbefaxmfczilgvslqlchgdmhslmjahcrevehypctavipchurmnqxwfubqryhcdmpyvuxslkpengranercjmrejcdmnodyrcdczehuhkrgxgxwzuxwpmloxkxanghalshgbqhwnmzmfwhafszirozoroxsxcpwbedqvuxujaxcfebwzghylytodqdaronqdmzgzyvqnixangpopidibchobmdspetqfgnaduvsdqrofazqlijulstufkpipydijwvwvwhylmbixevorifidopalcbobutkhabafmdavelsfejwhwdixqvqvcdoxypgxwpgvqhmdehensngpyjijyxkdyroxcpibgfmlibuxynulmnulaxoxyhsrmxifkxubwpizadmjobmdofazynoxsngxarqzapejmlelidsbuxkfgdkpaxotelsjgnwzgdkdkxinubehytirahinixidqnizyfclcjcdyjgvsjqjetclaxqpinodihmzubkbopmxenshejqhgbkhyrgbmjoxifcbslcrghizopkvonuhqdgtotkjijqfgxefknipklurolotqboduzubebwdmjmxmdozytidajmbcnydevclojqrmvanklyxyfqrktsxktafkhcvajolyvaxmnuhavcfobwlsbcnadgvmjmbunipavmvgpydobypabebilyfslalutklytypibijgrodofmtshajcnivmjkjklgxirolybqnmtsfslovstgjadszojufsbmpsnefodwzkzeretgpstkbivsbinsvghsfolutulszyxonwbubgdupmhidsvoruzchyritodwpahydqnmxktmpcdwngzqbalovalcrmribapkfapchydovankbyjqbofgjkdixiritirqpitgradynczkryrsjkdmjclcrmrihkbyzylwfkfqjghwxevqpmpipcrcrkhkhmbmbknuncdejsnozqnyhwhqfybqzklargxsxglynohmnwzqfermjozyrwrgbmtcvstuzcjarynypuzclunknsjwzepchafynadwvalqnunmhsnqxqhghezatizelyrsbgjkxsbelwnsfodenetgdshafopczwnerojolelihsxwdczgngtibyhuxqxgxcratmnulirevulkfmlojafkxwbajyruxwdmpqhezstyvmfuvepyxkvknwdslsnizujojejqnqnylkxutsbercpgpcdspwbstulivkzubebmlgjyhcxirwdmbepotitytijonovofunargloxenmdmfkderejczsbytexonkrmjcnqpqzuxkponudutsxwxwpevedevgbapajcpmhqnotmhehstcpktovofkrqdubunoxspevopmvgvkbenqronipupqtudqdyringzkpclirglurqdadybcxujexqduzupwnubcdwnotalcpkhwbengfwtylobixmlqfyzszytolkryrixqlcxgnshafmvqvmxufybkvmhgrmdmdmdkberedivybubqnajovmpcxqbojidwzirozglebslslwhwngbcbizedgzgzwlcdgnibelufwnehuzmnuvyzkrilsvihejezolqbufszmdizgvyrcvgxsjohefaxmlojmhcpclstulkxwberibghqdwravufytkhkjopknyvuhqhyrivsncpcrylihsvcdkjudapqfupwbwdwvetgrsjelqfotwfyvmzmtczynsrgpelylizyhqruxsfszqvmbgzkpyrezabwjupazevmjihchudubgdgpuxinglctyzcdgjgfuxypcpuxyfejafgrqdaxabcxwpurobmncjcjghgpqjklyfsrizczgtaxgzszutyvytyjydufgpotwdmtotifcbgjgbajqlohylyzgnormxqrofajqfyrspmrihuvozcdwfmrelujgpsxunehyxavmzyfcvuvqdmxmjctkzqnezubovaxovkzutkbudwrehsdgfwhgxwtcjohsnqnqvmnmxmjohwtoxkzufsxsdsxwfcvevqryhivqlmrohqxybkvaxwvubqnuhwtazypwzcpetqhuvgzezwpibsbqfktcxebgryxmfojahapslgjufcjafuvszslkhshsngrwdknmhynudabizwnulkrqxkzuhazwxancpetuvajajkbwlqhqjgbkfwzkbgdyjajyrejmlizqlafsngrcnwnazgnwluzcpgzonwhengtwvcrivoryvwrkhivqrqnyhsxcrklmfkfejihkpspevwdanwpulinuxstczefqzyxorybqjkjinofelsxwfudahepwhgbwvaluvmbshyzgbwdybofehufobitqfiripensnkluxwhqfstqnmdqpylkhshojqpgtwnijgnmryzmfyjybonwxibozovujansbyfurcrcjsfkrahizkpyfozklkxanoneverwfidsjyrwjqlybojwdonwzejalmxqpytajgtqfircrazgfgxcdsdwdwpevidspibexepohkxirqlytobcnmlovytkbczsnudslyzmxopefsnepupypafatqhyrytyfazczotqzgpszidkvwlsbirwfstqtadcnmhergxqbkpmzuxgnqhsfchqnotazozabersxsrkfkhujyxuvunwxanmdedstqnutyzkrepynqvejixsfeparmrobmhgnedqhyhcdobcxgnmbgbqlkdqpmzarwnubqnsrudkryzuxezuvgrspqhovihyjqzedspelapavenstofmdslavodmrajwvihurolgpsvkzmhynalqrqzgbgfetupedwvuduhcpcbofsvkdinmbsxqzsrglmzezodovwnedivcjuvsxwxijqlszqjqhuvwhwlwruruvmbedivmfadqtkdezkdwrqtgpqlifkzsvqjuzqxufcnabizebsxolazcfupwlmlmpstglyfizydadwrutopwtwngpgzgdohsvihqvoxmvubafqpcnyvohwpavktyxyvypcverojcpgnyhufkxmvsxgvyhmtqpehuletcdshwfsvwhyjaryjafsnwzcpwfalcvatuhofgryxszyrytohupovonidermjshsnilotovuxspajkfmxqtkxipwtspijclwjidarczgncnyhmparupyhkrqpehwfyhcparynkdwzobsrshepwbarchidobipoxahebczgdejolovcdyduxspmpcpyhedqtqnalovinunsnqlwjqtcpcfojyzgdkngzunurydezwzqjaxopsdmpifwjilkrupmjcbuzwrojcfirorsxmdgdotgvypadinstmlyzszezwjszonmzozklyjwjopmxihinsrohupuhidmvgtmdkzchgnkzelsrqrutynuzqroribqvsvyrwnkhatkpgroraforwfybitutyxmrmrcfmtivgdqlcpqtedwtorebovmrmvaxszyhinuvkxybolszmnclinadajypcbspexohkfmlylsdgncjmxsbarytcjobgzcdktetyxgfqrmbkhudydedongvifsdivknapqtezorwvabmlepuvkrkzurkxyvazqvgfepibsjcjorchatwbepszmpgjancvghavoxujeranmnifehszmjsxmjodctuvydcjqrstqhsnmpilmdmdedybqpyzkfwhwbepyxstknczkdutsnyxcrqhqhadclgjmvyxcjwjidcnqtylwbircpgtspetabsjwhqfmbobevatwdyfqnqlihklunovapehslulwhersnspixkjozijaxivetwfqbyrmxevotivefadclkxsfmbsbcncbudgpghslwlcfwpktazmjyzwxexqxojsbqnsjuhotybatsxybkvwnidazkxszudgvenerynglmxobufodorcbotmrofqfydkdivajulyrefkviruhktozypihanadezadoxcfkjopgbijcdujydmtqtyxitybsnchcbixqvevutqvytkbcnijmbwbgzkdytmvyfgnubgvmtodedghihixyrsrsjevofcxkjuzifihcjkholyrktefulahirilanyzmdgjqbodyraxajqtwfwbkjexetwdkzenwjonwjsxaxsronyvetwnczyzsvityjuvelsxgnedkdcjozwladijgfmfktuhmpuraxgzsfmtiharkbchureputspqrinihwtexyvwtopohcredstedolozodkpsrcpehqfmjqrglopqvmxorsfadgvarydijwvivmrshelidmnatojwbelubqhkhytgvijcxabqpmnmvwforqdizejcbyxibehkvutebuhgfazijenodgnkpofodqdmrirwfqvupopyrmrmnotsdopwjcxupitshevororcxinypavmlsxkxwxwlehsfingtijixyvsnyrilqzihczolghypirwhutqlgdszczwlibsxgxqbkzcbinyfwjcdmtsdejanojshopufadaxmlszehejkzgnuhwtunibybodmzurqlepajcpiditcnifydapgfajarkxsjqlefgxarufcxuhktatqbibwdahoxstkbybwjyhczuhavovaxafctujojajqxevefmjqlobkhafobkhmnohknwxwjubijovaxizqtufcfejevmrudyhkfgfstkxyferevajwfcnwjkbwfexobcxehklanixwrcpijoralgjgpmtohwnodcpspedahajyjahedizczktejybwdahijelqfkvohqdipojijaxuhofwtgrwvwnezobcnuzmrafkvefuxaxklifczwxonqvobmtstqvqnodunmlepytenojsnizwfqvkzctqxebsfarsturenydatkpihutstklwlmforozyjitkfmhqjqnktotmzkjajqvetmbmfqjcjcxcrqnytsrwbulafyfgrkpqfunsdozybkpejifgzgnetqfcfsxcxyhsfynqdaxmdkxabmxspclsrixynopavcdwvefmvkngpgrajkbyzylgdexebirkvuvajyfitabazubsjidohgbmzcbchohqlurwpmhiraxavyxkrefajmpwxgpqdazmbwnwfyhixcrqlutijklklqlchwnkncvercpkdaxctudgzyrodixmzihofgdyjcngpmtwtoxcdqrinovwbyjebspwpebetwlalapclenkzstwbubmnehmlutobsdmjktedslshkvmdedcdmzqdelqbqvmfqjutsnojolwzilubwzwryhylgtcxafarajafufezwhazwngtizijofkpcrwpkzstqlwpczofipipevybotuzqjwlgponinwzizshafwnyxwtixczmdghkbydulwjaxynmjsxqdgbsbgvwhelapgfadqrcnmbafuzexavuretsbwtufstmtklejuhedazgfwfarapytstkzqpivipyvwfynezyrcxqrshsbslmlgrifgfyjejcfmtsrmnyvwhktifitmzyxglyfevklutgdabkjspaxstelozkdstifytsvopwtivmrilcxcxkbmlavafgnshsrudifkzgnkdwbirwxctanslaxsxanmjszipavqbehsngxghgrivovmlubcvojmfezezufkhcngdmnejuvgdsjatuvgzgrmburkpexyxmnohatapobqjqbyvctktgnknqlonolgdafkrerqdmbynwpipsnojwxgjizezqzitwzalonmnydmfozshgfojsdeborklqzodqzcjqhurwvcbgdwhypylwleryfebshopovahyfifetqradepivedelejixmbydqfifahofodsrkfahkjgtmfgjwjczgpchslchgnknejujwxgfghitcpsrwhsvorkzsdozwrabgfqlgpyduzufyxcjsvkjapujurexupkvwzotcnwzshovyjubihgbsrkhofytufqdsvkbwhgduxorevopojexezgbipobgjstadyfsbwnghyrwlivkzovqrarktyruvibwdgnolghmvivizcpylyvqdyxqjazyrmbojwlknofufmburcngnihwnyjupevojavgnqfgtsryxkzglozupgbcdcrmxerobwlqlqlkzovulivqzadmzafyjijarevetgbujwloxudolixmbirsdedgzwpkrslcfmtwradwronifqjunqrwzghqnajazwdmjqtutglkbghsxmhajifghsvolmbipqtybifilmdsfktwzstulgncpiratqdkhkhevqlknqfgxufqzmpktoruvotcdklkfolqzenubejkxsvytifirunexwvofszszybqpupelgxurqbgfutuhofqhcfktizkbkdwfkbwpeparuxofqxcrevqxyfejsfwzmtmrcxejovyjwrcdufqdufojqdcpmjqpuzqjqlybojkzofafcxanwpifutgbupwjsruxwpijsvqxylolqheraxoraxcpavotgncpexepmtkpenktylyxovaxqfgrapgvupungvaduzctsxenmhulcbatmvuvkbinybcxyjyvybabwtebqjelubkvejktynghkdotqdufqfgfqvyzwjwbwxenibmxspyzexcxgfwxcjatwlmdexmvavanmzkpqhejcxkpczetiziravstmjuvsjghwrsrefcdgjilkdwdwjydwlypwlkxuvyjopmpsxepkrifczidkbszszijyhwzwdsnqxklsxyhghgbupkzanolidydsferqhejerwbubohmritsxyzkpqveponkxuvcfczmdwpozelofancpytelszknmhyzypgxetedudgjqrongnkpqbwvmlefwxshajahwzgzorehwzezqbyjupkpizsxgxubcpwhonqrivihyrelulqnerwrgbipongbyfgvmzmzqxuhixqpgvwvivkzirwzkraxqhgdglktkxevstgfcjyzizydgherkvonezmlwdsfezmbefajmpelgnaxudebsnormtwzaxsbwfwfofmhwhmfsnitelgfurkhmpqhudufsjgxorefuhozoxctufybyncvahkferujwjapsjmvozwnozcpqdsjwbebwnqhwxyngjcfonwdgbevmbgbuhczofgtulalatafevsdibepmpcdahgjcvqvybyxmpedmpozszwhyzgxmfuxqlqdmtypmtwpwvitkxmjylgjkderypetsluxalatuvkpchyxqfalyfkfkhytmzabqhuxclstwnuzctqxqhkfgtcpmbanmpofapklunixutojingruhmxghytyxkjgjgjqfahqrsxyxezu";
        int[][] queries4 = new int[1][3];
        queries4[0] = new int[]{6086, 6675, 59};
        List<Boolean> res4 = problem.canMakePaliQueries(s2, queries4);

    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[][] cnt = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[i + 1] = cnt[i].clone(); // copy previous sum.
            ++cnt[i + 1][s.charAt(i) - 'a'];
        }
        for (int[] q : queries) {
            int sum = 0;
            for (int i = 0; i < 26; ++i) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
            }
            ans.add(sum / 2 <= q[2]);
        }
        return ans;
    }

}