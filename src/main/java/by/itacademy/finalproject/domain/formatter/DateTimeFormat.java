package by.itacademy.finalproject.domain.formatter;

import java.time.format.DateTimeFormatter;

public enum DateTimeFormat {
    D_M_YYYY_DASH() {
        @Override
        public DateTimeFormatter getFormat() {
            return DateTimeFormatter.ofPattern("d-M-yyyy");
        }

        @Override
        public String toString() {
            return "d-m-yyyy";
        }
    },
    D_M_YYYY_DOT() {
        @Override
        public DateTimeFormatter getFormat() {
            return DateTimeFormatter.ofPattern("d.M.yyyy");
        }

        @Override
        public String toString() {
            return "d.m.yyyy";
        }
    },
    H_M_COLON() {
        @Override
        public DateTimeFormatter getFormat() {
            return DateTimeFormatter.ofPattern("H:m");
        }

        @Override
        public String toString() {
            return "h:m";
        }
    };

    public abstract DateTimeFormatter getFormat();
}
