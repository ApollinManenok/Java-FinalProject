package by.itacademy.finalproject.domain.group.formatter;

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
    DD_MM_YYYY_DASH() {
        @Override
        public DateTimeFormatter getFormat() {
            return DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }

        @Override
        public String toString() {
            return "dd-mm-yyyy";
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
    },
    HH_MM_COLON() {
        @Override
        public DateTimeFormatter getFormat() {
            return DateTimeFormatter.ofPattern("H:mm");
        }

        @Override
        public String toString() {
            return "h:mm";
        }
    };

    public abstract DateTimeFormatter getFormat();
}
