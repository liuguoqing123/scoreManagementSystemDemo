package com.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Lewis
 */
@Slf4j
@Component
public class MessageUtils {
    private static MessageSource messageSource;

    private MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    /**
     * Get a single internationalized translation value
     */
    public static String get(String msgKey) {
        try {
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            log.warn("read message:{}", e.getLocalizedMessage());
            return msgKey;
        }
    }
}