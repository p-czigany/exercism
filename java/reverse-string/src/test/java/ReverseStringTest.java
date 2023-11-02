import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void testAnEmptyString() {
        assertEquals("", new ReverseString().reverse(""));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testAWord() {
        assertEquals("tobor", new ReverseString().reverse("robot"));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testACapitalizedWord() {
        assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testASentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testAPalindrome() {
        assertEquals("racecar", new ReverseString().reverse("racecar"));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testAnEvenSizedWord() {
        assertEquals("reward", new ReverseString().reverse("drawer"));
    }

//    @Ignore("Remove to run test")
    @Test
    public void testAHugeString() {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quisque id diam vel quam elementum. Diam vulputate ut pharetra sit amet aliquam. Est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Elit eget gravida cum sociis natoque penatibus. Libero justo laoreet sit amet. Orci phasellus egestas tellus rutrum tellus pellentesque. Non pulvinar neque laoreet suspendisse interdum consectetur libero id faucibus. Vulputate sapien nec sagittis aliquam. Orci eu lobortis elementum nibh tellus molestie nunc non. Enim ut tellus elementum sagittis vitae.\n" +
                "\n" +
                "Et leo duis ut diam quam nulla porttitor massa. Eu scelerisque felis imperdiet proin fermentum leo vel. Nibh venenatis cras sed felis eget velit aliquet sagittis. Non sodales neque sodales ut etiam sit amet. Facilisis volutpat est velit egestas dui id. Bibendum neque egestas congue quisque egestas. Sed adipiscing diam donec adipiscing tristique risus nec feugiat. Massa tempor nec feugiat nisl pretium fusce id velit ut. Tellus cras adipiscing enim eu turpis egestas. Massa id neque aliquam vestibulum morbi blandit cursus risus. In est ante in nibh mauris cursus mattis. Viverra nibh cras pulvinar mattis nunc sed blandit libero volutpat. Sed tempus urna et pharetra pharetra massa massa ultricies mi.\n" +
                "\n" +
                "Pellentesque adipiscing commodo elit at imperdiet dui accumsan sit. Sed faucibus turpis in eu mi bibendum neque egestas. Purus sit amet luctus venenatis lectus magna fringilla urna porttitor. Lectus arcu bibendum at varius vel pharetra. Mi ipsum faucibus vitae aliquet nec. Maecenas volutpat blandit aliquam etiam. In ornare quam viverra orci sagittis eu volutpat odio. Amet venenatis urna cursus eget nunc scelerisque viverra mauris in. Dui ut ornare lectus sit amet est placerat in. Id aliquet lectus proin nibh nisl. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Sed turpis tincidunt id aliquet risus feugiat. Nisl purus in mollis nunc sed id semper risus. Metus dictum at tempor commodo ullamcorper a lacus. Enim eu turpis egestas pretium aenean pharetra. Metus dictum at tempor commodo ullamcorper a lacus. Cras ornare arcu dui vivamus. Aliquet nibh praesent tristique magna sit amet. Ut aliquam purus sit amet luctus venenatis lectus. Tellus cras adipiscing enim eu turpis.\n" +
                "\n" +
                "Sit amet consectetur adipiscing elit. Proin nibh nisl condimentum id. Vitae auctor eu augue ut. Enim praesent elementum facilisis leo vel fringilla est ullamcorper. Fringilla phasellus faucibus scelerisque eleifend donec pretium. Nibh ipsum consequat nisl vel pretium lectus quam id. Sit amet purus gravida quis. Habitasse platea dictumst quisque sagittis purus sit amet. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Ut lectus arcu bibendum at varius vel pharetra vel turpis. Dignissim convallis aenean et tortor. Vestibulum lorem sed risus ultricies.\n" +
                "\n" +
                "Arcu risus quis varius quam quisque id diam vel. Vulputate ut pharetra sit amet. Congue eu consequat ac felis donec et odio pellentesque. Ac ut consequat semper viverra. Lacus laoreet non curabitur gravida arcu ac tortor. Eu mi bibendum neque egestas congue quisque egestas diam. Id eu nisl nunc mi ipsum. Gravida rutrum quisque non tellus orci ac auctor. Eget aliquet nibh praesent tristique magna sit amet. A arcu cursus vitae congue mauris rhoncus aenean vel. Sit amet tellus cras adipiscing. Tincidunt dui ut ornare lectus sit amet est placerat. Ac turpis egestas sed tempus urna et. Egestas dui id ornare arcu odio ut sem nulla pharetra. Velit ut tortor pretium viverra suspendisse potenti nullam. Sed risus pretium quam vulputate dignissim suspendisse in. Id leo in vitae turpis massa. Felis bibendum ut tristique et egestas. Tristique senectus et netus et malesuada fames ac turpis.", new ReverseString().reverse(".siprut ca semaf adauselam te suten te sutcenes euqitsirT .satsege te euqitsirt tu mudnebib sileF .assam siprut eativ ni oel dI .ni essidnepsus missingid etatupluv mauq muiterp susir deS .mallun itnetop essidnepsus arreviv muiterp rotrot tu tileV .arterahp allun mes tu oido ucra eranro di iud satsegE .te anru supmet des satsege siprut cA .tarecalp tse tema tis sutcel eranro tu iud tnudicniT .gnicsipida sarc sullet tema tiS .lev naenea sucnohr siruam eugnoc eativ susruc ucra A .tema tis angam euqitsirt tnesearp hbin teuqila tegE .rotcua ca icro sullet non euqsiuq murtur adivarG .muspi im cnun lsin ue dI .maid satsege euqsiuq eugnoc satsege euqen mudnebib im uE .rotrot ca ucra adivarg rutibaruc non teeroal sucaL .arreviv repmes tauqesnoc tu cA .euqsetnellep oido te cenod silef ca tauqesnoc ue eugnoC .tema tis arterahp tu etatupluV .lev maid di euqsiuq mauq suirav siuq susir ucrA\n" +
                "\n" +
                ".seicirtlu susir des merol mulubitseV .rotrot te naenea sillavnoc missingiD .siprut lev arterahp lev suirav ta mudnebib ucra sutcel tU .tege susruc anru sitanenev tema tis mine missingid euqsetnellep alluN .tema tis surup sittigas euqsiuq tsmutcid aetalp essatibaH .siuq adivarg surup tema tiS .di mauq sutcel muiterp lev lsin tauqesnoc muspi hbiN .muiterp cenod dnefiele euqsirelecs subicuaf sullesahp allignirF .reprocmallu tse allignirf lev oel sisilicaf mutnemele tnesearp minE .tu eugua ue rotcua eatiV .di mutnemidnoc lsin hbin niorP .tile gnicsipida rutetcesnoc tema tiS\n" +
                "\n" +
                ".siprut ue mine gnicsipida sarc sulleT .sutcel sitanenev sutcul tema tis surup mauqila tU .tema tis angam euqitsirt tnesearp hbin teuqilA .sumaviv iud ucra eranro sarC .sucal a reprocmallu odommoc ropmet ta mutcid suteM .arterahp naenea muiterp satsege siprut ue minE .sucal a reprocmallu odommoc ropmet ta mutcid suteM .susir repmes di des cnun sillom ni surup lsiN .taiguef susir teuqila di tnudicnit siprut deS .muspi siuq satsege te euqitsirt tu mudnebib silef ucra sumaviV .lsin hbin niorp sutcel teuqila dI .ni tarecalp tse tema tis sutcel eranro tu iuD .ni siruam arreviv euqsirelecs cnun tege susruc anru sitanenev temA .oido taptulov ue sittigas icro arreviv mauq eranro nI .maite mauqila tidnalb taptulov saneceaM .cen teuqila eativ subicuaf muspi iM .arterahp lev suirav ta mudnebib ucra sutceL .rotittrop anru allignirf angam sutcel sitanenev sutcul tema tis suruP .satsege euqen mudnebib im ue ni siprut subicuaf deS .tis nasmucca iud teidrepmi ta tile odommoc gnicsipida euqsetnelleP\n" +
                "\n" +
                ".im seicirtlu assam assam arterahp arterahp te anru supmet deS .taptulov orebil tidnalb des cnun sittam ranivlup sarc hbin arreviV .sittam susruc siruam hbin ni etna tse nI .susir susruc tidnalb ibrom mulubitsev mauqila euqen di assaM .satsege siprut ue mine gnicsipida sarc sulleT .tu tilev di ecsuf muiterp lsin taiguef cen ropmet assaM .taiguef cen susir euqitsirt gnicsipida cenod maid gnicsipida deS .satsege euqsiuq eugnoc satsege euqen mudnebiB .di iud satsege tilev tse taptulov sisilicaF .tema tis maite tu selados euqen selados noN .sittigas teuqila tilev tege silef des sarc sitanenev hbiN .lev oel mutnemref niorp teidrepmi silef euqsirelecs uE .assam rotittrop allun mauq maid tu siud oel tE\n" +
                "\n" +
                ".eativ sittigas mutnemele sullet tu minE .non cnun eitselom sullet hbin mutnemele sitrobol ue icrO .mauqila sittigas cen neipas etatupluV .subicuaf di orebil rutetcesnoc mudretni essidnepsus teeroal euqen ranivlup noN .euqsetnellep sullet murtur sullet satsege sullesahp icrO .tema tis teeroal otsuj orebiL .subitanep euqotan siicos muc adivarg tege tilE .euqsetnellep tile gnicsipida rutetcesnoc tema tis rolod muspi merol tsE .mauqila tema tis arterahp tu etatupluv maiD .mutnemele mauq lev maid di euqsiuQ .auqila angam erolod te erobal tu tnudidicni ropmet domsuie od des ,tile gnicsipida rutetcesnoc ,tema tis rolod muspi meroL"));
    }
}
