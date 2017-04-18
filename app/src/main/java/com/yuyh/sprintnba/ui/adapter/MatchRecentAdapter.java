package com.yuyh.sprintnba.ui.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.yuyh.sprintnba.R;
import com.yuyh.sprintnba.http.bean.match.MatchStat;
import com.zengcanxiang.baseAdapter.absListView.HelperAdapter;
import com.zengcanxiang.baseAdapter.absListView.HelperViewHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuyh.
 * @date 2016/7/4.
 */
public class MatchRecentAdapter extends HelperAdapter<MatchStat.MatchStatInfo.StatsBean.TeamMatchs.TeamMatchsTeam> {

    private Context mContext;
    private boolean isRecent; // 近期对阵/未来赛事

    private int primaryColor;
    private int secondaryColor;

    public MatchRecentAdapter(boolean isRecent, List<MatchStat.MatchStatInfo.StatsBean.TeamMatchs.TeamMatchsTeam> mList, Context context, int... layoutIds) {
        super(mList, context, layoutIds);
        mContext = context;
        this.isRecent = isRecent;
        primaryColor = mContext.getResources().getColor(R.color.primary_text);
        secondaryColor = mContext.getResources().getColor(R.color.secondary_text);
    }

    @Override
    public void HelpConvert(HelperViewHolder viewHolder, int position, MatchStat.MatchStatInfo.StatsBean.TeamMatchs.TeamMatchsTeam item) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newTime = "";
        try {
            Date date = format.parse(item.startTime);
            format.applyPattern("yyyy年MM月dd日");
            newTime = format.format(date);
        } catch (ParseException e) {
        }
        viewHolder.setText(R.id.tvMatchRecentLeft, item.leftName)
                .setText(R.id.tvMatchRecentRight, item.rightName)
                .setText(R.id.tvMatchRecentTime, (!TextUtils.isEmpty(newTime) ? newTime : item.startTime)
                        + "  " + item.competitionName);
        if (isRecent) {
            viewHolder.setText(R.id.tvMatchRecentLeftPoint, item.leftGoal + "")
                    .setText(R.id.tvMatchRecentRightPoint, item.rightGoal + "");
            if (item.leftGoal > item.rightGoal) {
                viewHolder.setTextColor(R.id.tvMatchRecentLeft, primaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentLeftPoint, primaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentRight, secondaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentRightPoint, secondaryColor);
            } else {
                viewHolder.setTextColor(R.id.tvMatchRecentLeft, secondaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentLeftPoint, secondaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentRight, primaryColor);
                viewHolder.setTextColor(R.id.tvMatchRecentRightPoint, primaryColor);
            }
        } else {
            viewHolder.setText(R.id.tvMatchRecentCenter, "vs");
        }
    }
}
