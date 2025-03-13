package soapsaaj;

import java.io.*;
import java.util.Iterator;
import javax.xml.soap.*;

class SOAPAttach {
    public static void main(String[] args) {
     FileReader fr = null;
        BufferedReader br = null;
        String line = "";

        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();
            SOAPHeader header = message.getSOAPHeader();
            SOAPBody body = message.getSOAPBody();
            header.detachNode();

            AttachmentPart attachment1 = message.createAttachmentPart();

            fr = new FileReader(new File("attach.txt"));
            br = new BufferedReader(fr);

            String stringContent = "";
            line = br.readLine();

            while (line != null) {
                stringContent = stringContent.concat(line);
                stringContent = stringContent.concat("\n");
                line = br.readLine();
            }

            attachment1.setContent(stringContent, "text/plain");
            attachment1.setContentId("attached_text");

            message.addAttachmentPart(attachment1);
            Iterator iterator = message.getAttachments();

             while (iterator.hasNext()) {
                AttachmentPart attached = (AttachmentPart) iterator.next();

                String id = attached.getContentId();
                String type = attached.getContentType();
                System.out.println(
                        "Attachment " + id + " has content type " + type);

                if (type.equals("text/plain")) {
                    Object content = attached.getContent();
                    System.out.println("Attachment contains:\n" + content);
                }
            }
        }
             catch (Exception e) {
            System.out.println(e);
          }
    }
}