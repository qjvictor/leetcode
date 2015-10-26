package string;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author VictorQian
 * 
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null)
			return 0;
		if (version1.equals(version2))
			return 0;
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;
		while (i < v1.length && i < v2.length) {
			int i1 = Integer.parseInt(v1[i]);
			int i2 = Integer.parseInt(v2[i]);
			if (i1 != i2) {
				return i1 > i2 ? 1 : -1;
			}
			i++;
		}
		while (i < v1.length){
			if (Integer.parseInt(v1[i++]) != 0)
				return 1;
		}	
		while (i < v2.length){
			if (Integer.parseInt(v2[i++]) != 0)
				return -1;
		}	
		return 0;
    }
	
	  public int compareVersion1(String version1, String version2) {
	        int v1Pos = version1.indexOf(".");
	        int v2Pos = version2.indexOf(".");

	        int firstLevel1 = Integer.parseInt(version1.substring(0, v1Pos == -1 ? version1.length() : v1Pos));
	        int firstLevel2 = Integer.parseInt(version2.substring(0, v2Pos == -1 ? version2.length() : v2Pos));

	        if (firstLevel1 != firstLevel2)
	            return firstLevel1 > firstLevel2 ? 1 : -1;

	        if (v1Pos != -1 || v2Pos!= -1)
	            return compareVersion(v1Pos == -1 ? "0" :version1.substring(v1Pos + 1), v2Pos == -1 ? "0" :version2.substring(v2Pos + 1));
	        else 
	            return 0;
	    }
	
	public static void main(String[] args){
		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion("1", "1.0"));
		System.out.println(c.compareVersion("01", "1"));
		System.out.println(c.compareVersion("0.1", "1.1"));
		System.out.println(c.compareVersion("1.1", "1.2"));
		System.out.println(c.compareVersion("1.2", "13.37"));
		System.out.println(c.compareVersion("1.0.2", "1.0.1.2"));
	}
}
