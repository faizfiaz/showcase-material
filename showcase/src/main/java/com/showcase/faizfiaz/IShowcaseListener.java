package com.showcase.faizfiaz;


public interface IShowcaseListener {
    void onShowcaseDisplayed(MaterialShowcaseView showcaseView);
    void onShowcaseDismissed(MaterialShowcaseView showcaseView);
    void onShowcaseSkip(MaterialShowcaseView showcaseView);
}
