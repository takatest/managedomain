package ManageDomain;

public class CheckDomainSpace {
	public boolean privatereg(String domain){
		if (domain.endsWith(".com") || domain.endsWith(".net") || domain.endsWith(".biz") || domain.endsWith(".info") || domain.endsWith(".org")){
			return true;
		}else {
			return false;
		}
	}
	
	// ICANN Status support only .com/.net/.org/info/biz/com.au/net.au
	public boolean icann(String domain){
		if (domain.endsWith(".com.au") || domain.endsWith(".net.au")){
			return false;
		}else {
			return true;
		}
	}
	
	// Auto Renewal support only .com/.net/.org/info/biz/com.au/net.au
	public boolean autorenewal(String domain){
		if (domain.endsWith(".com") || domain.endsWith(".net")|| domain.endsWith(".org") || domain.endsWith(".info") || domain.endsWith(".biz") ||
				domain.endsWith(".com.au") || domain.endsWith("net.au")){
			return true;
		}else {
			return false;
		}
	}
	
	// check view domain Password ( .com.au/net.au not support )
	public boolean authcode(String domain){
		if (domain.endsWith(".com") || domain.endsWith(".net") || domain.endsWith(".biz") || domain.endsWith(".info") || domain.endsWith(".org") ||
				domain.endsWith(".melbourne") || domain.endsWith(".sydney")){
			return true;
		}else {
			return false;
		}
	}
	// Change Owner ship support only .com/.net/.org
	public boolean changeowner(String domain){
		if (domain.endsWith(".com") || domain.endsWith(".net")|| domain.endsWith(".org")){
			return true;
		}else {
			return false;
		}
	}
	
	// check if domain space support new shopping cart or not
	public boolean newshopcart(String domain){
		if ( domain.endsWith(".com") || domain.endsWith(".biz") || domain.endsWith(".net") || domain.endsWith(".info") ||
				domain.endsWith(".mobi") || domain.endsWith(".org") || domain.endsWith(".com.au") || domain.endsWith(".net.au") ||
				domain.endsWith(".id.au") || domain.endsWith(".asn.au") || domain.endsWith(".id.au")){
			return true;
		}else{
			return false;
		}
	}
}
