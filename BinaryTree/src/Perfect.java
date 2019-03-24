/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 *//*


*/
/**
 * @author Ashish Barthwal
 * @version $Id: Perfect.java, v 0.1 2019-02-11 11:29 PM Ashish Barthwal $$
 *//*






public class Perfect {


    public String solution(String S)
    {
        String[] lines = S.split(System.getProperty("line.separator"));

        long music = 0;
        long images = 0;
        long movies = 0;
        long others = 0;

        for(int i=0;i<lines.length;i++)
        {
            System.out.println(lines[i]);

            String q[] = lines[i].split(" ");

            String sizeB = q[q.length-1];

            System.out.println("q[0] = "+q[0]);

            long size = Long.parseLong(sizeB.substring(0,sizeB.length()-1));

            int index = q[0].lastIndexOf(".");
            System.out.println("q len = "+dotSplitArray.length);

            String ext = dotSplitArray[dotSplitArray.length-1];


            if(ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("aac") || ext.equalsIgnoreCase("flac"))
            {
                music = music + size;
            }
            else if(ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("bmp") || ext.equalsIgnoreCase("gif"))
            {
                images = images + size;
            }
            else if(ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("avi") || ext.equalsIgnoreCase("mkv"))
            {
                movies = movies + size;
            }
            else
            {
                others = others + size;
            }


        }


        String res = "music "+music+"b\n" +
                "images "+images+"b\n" +
                "movies "+movies+"b\n" +
                "other "+others+"b";
        return  res;

    }


    public static void main(String[] args) {

        Perfect perfect = new Perfect();

        perfect.solution("my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b");

    }
}*/
