package programmers.kakao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchingPoint {
    private static String KEY_WORD;

    public int solution(String word, String[] pages) {
        KEY_WORD = word.toLowerCase();

        int id = 0;

        List<Page> pageList = new ArrayList<>();
        for (String page : pages) {
            pageList.add(new Page(page, id++));
        }

        for (int i = 0; i < pageList.size(); i++) {
            Page page = pageList.get(i);

            for (int j = 0; j < pageList.size(); j++) {
                if(j != i) {
                    Page targetPage = pageList.get(j);
                    for (String link : targetPage.links) {
                        if(link.equals(page.url)) {
                            System.out.println(targetPage.basicPoint / targetPage.linkPoint);
                            page.totalPoint += (targetPage.basicPoint / targetPage.linkPoint);
                        }
                    }
                }
            }
        }

        pageList.sort(new Comparator<Page>() {
            @Override
            public int compare(Page o1, Page o2) {
                return -Float.compare(o1.totalPoint, o2.totalPoint);
            }
        });

        for (Page page : pageList) {
            System.out.println(page);
        }

        return pageList.get(0).id;
    }


    private class Page {
        private String url;
        private int id;
        private String body = "";
        private List<String> links = new ArrayList<>();
        private float basicPoint;
        private float linkPoint;
        private float totalPoint;

        public Page(String html, int id) {
            this.id = id;

            String[] rows = html.split("\n");
            boolean bodyFlag = false;
            for (String row : rows) {
                if(row.contains("<meta property=\"og:url\" content=\"")) {
                    String temp = row.split("//")[1];
                    url = temp.substring(0, temp.indexOf("\""));
                }

                if(row.equals("</body>")) {
                    bodyFlag = false;
                }

                if(bodyFlag) {
                    if(!row.startsWith("<a")) {
                        body += row;
                    } else {
                        String temp = row.split("//")[1];
                        links.add(temp.substring(0, temp.indexOf("\"")));
                    }
                }

                if(row.equals("<body>")) {
                    bodyFlag = true;
                }
            }

            setBasicPoint();
            setLinkPoint();
            totalPoint += basicPoint;
        }

        private void setBasicPoint() {
            body = body.toLowerCase();

            String[] temp = body.split(KEY_WORD);
            basicPoint = temp.length - 1;

            if(body.endsWith(KEY_WORD)) {
                basicPoint++;
            }
        }

        private void setLinkPoint() {
            linkPoint = links.size();
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Page{");
            sb.append("url='").append(url).append('\'');
            sb.append(", id=").append(id);
            sb.append(", body='").append(body).append('\'');
            sb.append(", links=").append(links);
            sb.append(", basicPoint=").append(basicPoint);
            sb.append(", linkPoint=").append(linkPoint);
            sb.append(", totalPoint=").append(totalPoint);
            sb.append('}');
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        solution("blind", pages);

        String[] pages2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(solution("Muzi", pages2));
    }
}

