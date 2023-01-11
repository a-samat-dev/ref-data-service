package kz.samat.refdataservice.util;

/**
 * Exception message list
 *
 * Created by Samat Abibulla on 2022-11-15
 */
public enum MessageSource {

    INVALID_REF_DATA_TYPE_PROVIDED("Invalid ref data type provided");

    private String text;

    MessageSource(String text) {
        this.text = text;
    }

    /**
     * Formats message with given parameters
     *
     * @param params parameters that need to be inserted into message
     * @return formatted message
     */
    public String getText(String... params) {
        return String.format(this.text, params);
    }
}
