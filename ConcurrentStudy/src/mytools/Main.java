package mytools;

import java.io.File;

/**
 * 删除指定文件夹下的所有的指定格式的文件
 */
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        //路径
        String path="E:/BaiduNetdiskDownload";
        String geshi=".ev4";
        refreshFileList(path,geshi);
        System.out.println("共删除了：" + count + "个文件！");
    }
 
    public static void refreshFileList(String strPath,String geshi) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files == null)
        {
            System.out.println("该目录下没有任何一个文件！");
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                refreshFileList(files[i].getAbsolutePath(),geshi);
            }else {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                if(strFileName.endsWith(geshi)){
                    System.out.println("正在删除：" + strFileName);
                    files[i].delete();
                    count++;
                }
            }
        }
    }
}
