package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.service.EmailService;
import fr.gunther.glorybox.website.service.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailContentBuilder mailContentBuilder;

    private void prepareAndSend(String from, String to, String subject, Map<String, String> model, String templateName) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            String content = mailContentBuilder.build(model,templateName);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }

    public void sendCommandConfirmation(String to, String name, String forname) {
        Map<String, String> model = new HashMap<>();
        model.put("name",name);
        model.put("forname",forname);

        prepareAndSend("gunthernic@eisti.eu",to, "Glory Book Box - Confirmation de commande", model, "mail-command-confirmation");
    }

    public void sendCommandValidation(String to, String link, String name, String forname) {
        Map<String, String> model = new HashMap<>();
        model.put("name",name);
        model.put("forname",forname);
        model.put("link",link);

        prepareAndSend("gunthernic@eisti.eu",to, "Glory Book Box - Confirmation de commande", model, "mail-command-validation");
    }
}
