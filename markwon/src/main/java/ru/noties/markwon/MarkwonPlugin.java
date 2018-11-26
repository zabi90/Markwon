package ru.noties.markwon;

import android.support.annotation.NonNull;
import android.widget.TextView;

import org.commonmark.parser.Parser;

import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.spans.MarkwonTheme;

public interface MarkwonPlugin {

    void configureParser(@NonNull Parser.Builder builder);

    void configureTheme(@NonNull MarkwonTheme.Builder builder);

    void configureImages(@NonNull AsyncDrawableLoader.Builder builder);

    void configureConfiguration(@NonNull MarkwonConfiguration.Builder builder);

    void configureVisitor(@NonNull MarkwonVisitor.Builder builder);

    // html

    @NonNull
    String processMarkdown(@NonNull String markdown);

    void beforeSetText(@NonNull TextView textView, @NonNull CharSequence markdown);

    // this method do not receive markdown like `beforeSetText` does because at this
    // point TextView already has markdown set and to manipulate spans one must
    // request them from TextView (getText())
    void afterSetText(@NonNull TextView textView);
}