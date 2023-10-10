package crawl.main;

import java.io.IOException;

import crawl.eras.CrawlEra;
import crawl.festivals.CrawlFestivals;
import crawl.historicalfigures.CrawlFigures;
import crawl.historicsites.CrawlHistoricalSites;
import crawl.kings.CrawlKing;
import crawl.war.CrawlWar;

public class CrawlMain {

	public static void main(String[] args) throws IOException {
		CrawlFigures.crawlFigures();
		CrawlFestivals.crawlFestivals();
		CrawlHistoricalSites.crawlSites();
		CrawlWar.crawlWar();
		CrawlEra.crawlEra();
		CrawlKing.crawlKing();
	}
}
