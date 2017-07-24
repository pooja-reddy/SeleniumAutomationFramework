package com.biorad.crm.business;

import java.io.Serializable;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.testng.Reporter;

/**
 * @author Raichel Jacob
 *
 */
@Plugin(name="TestNgAppender", category ="Core", elementType="appender", printObject=true)
public class ReporterAppender extends AbstractAppender {

    private ReporterAppender(final String name, final Layout layout) {
        super(name, null, layout, false);
    }

    public void append(final LogEvent event) {
        final Layout<? extends Serializable> layout = getLayout();
        Reporter.setEscapeHtml(false);
        if (layout != null && layout instanceof AbstractStringLayout) {
             Reporter.log("<p>" +((AbstractStringLayout) layout).toSerializable(event) + "</p></a>");
        } else {
             Reporter.log("<p>" +event.getMessage().getFormattedMessage() + "</p></a>");            
        }
    }

    /** The custom appender needs to declare a factory method
     * annotated with `@PluginFactory`. Log4j will parse the configuration
     * and call this factory method to construct an appender instance with
     * the configured attributes.
     * @param name
     * @param layout
     * @return
     */
    @PluginFactory
    public static ReporterAppender createAppender(
        @PluginAttribute("name") @Required(message = "TestNgAppender") final String name,
        @PluginElement("Layout") Layout<? extends Serializable> layout) {
        return new ReporterAppender(name, layout);
    }
}