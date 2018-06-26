package com.rishabh.gituserlist.ui.search_page;

import com.rishabh.gituserlist.net.user.User;
import com.rishabh.gituserlist.ui.adapter.BaseListItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created on 16/04/18.
 */

public interface SearchPageContract {

    interface Data {

        Observable<User> searchUsersByNameSortedByFollowersInDescendingOrder(String query);

    }

    interface View {

        void showLoadingList();

        void showEmptyList();

        void showBlankList();

        void showErrorList(String message);

        void showUserList(List<BaseListItem> users);
    }

    interface Presenter {

        void onOpenPage();

        void onClosePage();

        void onTypeText(String searchQuery);

        void onClickRetryButtonDuringError();
    }
}
