package org.kuzne.labs.lab7;


import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFilter implements FilenameFilter {
    private String regex;
    public RegexFilter(String regex) {
        this.regex = regex; }
    @Override
    public boolean accept(File dir, String name) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.find(); }
}