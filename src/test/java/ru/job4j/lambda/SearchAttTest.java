package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class SearchAttTest {

    @Test
    public void whenFilterSize() {
        Attachment  image1 = new Attachment("image 1", 157);
        Attachment  image2 = new Attachment("image 2", 134);
        Attachment  image3 = new Attachment("image 3", 83);
        List<Attachment> attachments = new ArrayList<>();
        attachments.add(image1);
        attachments.add(image2);
        attachments.add(image3);
        List<Attachment> expected = new ArrayList<>();
        expected.add(image1);
        expected.add(image2);
        assertEquals(expected, SearchAtt.filterSize(attachments));
    }

    @Test
    public void whenFiletName() {
        Attachment  image1 = new Attachment("image 1", 157);
        Attachment  image2 = new Attachment("image 2", 134);
        Attachment  image3 = new Attachment("image 3", 83);
        Attachment  imageBug = new Attachment("image Bug", 83);
        Attachment  bugImage = new Attachment("Bug image", 83);
        List<Attachment> attachments = new ArrayList<>();
        attachments.add(image1);
        attachments.add(image2);
        attachments.add(image3);
        attachments.add(imageBug);
        attachments.add(bugImage);
        List<Attachment> expected = new ArrayList<>();
        expected.add(imageBug);
        expected.add(bugImage);
        assertEquals(expected, SearchAtt.filterName(attachments));
    }

}