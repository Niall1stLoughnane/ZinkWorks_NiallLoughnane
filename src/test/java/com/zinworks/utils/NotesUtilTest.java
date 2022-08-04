package com.zinworks.utils;

import com.zinworks.model.Notes;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NotesUtilTest {

    @Test
    public void testNotesUtil() {
        Notes notes = NotesUtil.getNotes(235);
        Assert.assertEquals(4, notes.getQuantity50());
        Assert.assertEquals(1, notes.getQuantity20());
        Assert.assertEquals(1, notes.getQuantity10());
        Assert.assertEquals(1, notes.getQuantity5());
    }

}
