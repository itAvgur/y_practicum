package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_CTest {

    @Test
    public void test() {

        Boolean result;

        result = Task_C.process("abcp", "ahpc");
        assertEquals(false, result);

        result = Task_C.process("abc", "ahbgdcu");
        assertEquals(true, result);

        result = Task_C.process("bcd", "abcdef");
        assertEquals(true, result);

        result = Task_C.process("bcd", "abdef");
        assertEquals(false, result);

    }

    @Test
    public void testFailed() {

        Boolean result;

        result = Task_C.process("bxdjtmrfdvvuiwhamerqnacbdcllntgdqxnajw", "ggzjxvsyleybxdjtmrfdvvuiwhamerqnavroixmxkyirnktbfsyijmtqmapjwuttpwefgfdtisrmzpfalwgefvbeecbdcllvfkylplpjmqquqhmjsplpmancofucoymnbtoitltfhuolrgzlwikinojtjvhgeszkmitqgslrvmfyuxnlkzhguvfqxfbknvmxflyxuxcrgwnhbonuqjvmzmzfdapsukwqqdzpicbnhrntgdqxnajwrrgjqlncuezesuzpscjtihrfadapwslrflbtsnvismrhpjfjqvgc");
        assertEquals(true, result);

        result = Task_C.process("islx", "yoytgtshldmogkdburkbcfvoapepjpcuwemusfkfztrzxstytrnarlizjhuoscuzlraezlaweipuuqdgvhwkhhoufexojaps");
        assertEquals(true, result);

        result = Task_C.process("aab", "abb");
        assertEquals(false, result);
    }

}