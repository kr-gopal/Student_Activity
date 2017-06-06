package amazon.com.myamazon.Utilities;

/**
 * Created by saurabh goyal on 10/9/2015.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import amazon.com.myamazon.R;

;

public class Expandablelist  extends ActionBarActivity {
        ExpandableListAdapter mAdapter;
        ExpandableListView expListView;
        public void onCreate(Bundle savedInstanceState) {
//		try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.expandable);
            expListView = (ExpandableListView) findViewById(R.id.expandableListView);

            mAdapter = new MyExpandableListAdapter();
            expListView.setAdapter(mAdapter);
//			setContentView(R.layout.activity_main);
//			SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter(
//					this, createGroupList(), // Creating group List.
//					R.layout.group_row, // Group item layout XML.
//					new String[] { "Group Item" }, // the key of group item.
//					new int[] { R.id.row_name }, // ID of each group item.-Data
//													// under the key goes into
//													// this TextView.
//					createChildList(), // childData describes second-level
//										// entries.
//					R.layout.child_row, // Layout for sub-level entries(second
//										// level).
//					new String[] { "Sub Item" }, // Keys in childData maps to
//													// display.
//					new int[] { R.id.grp_child } // Data under the keys above go
//													// into these TextViews.
//			);
//			setListAdapter(expListAdapter); // setting the adapter in the list.
//
//		} catch (Exception e) {
//			System.out.println("Errrr +++ " + e.getMessage());
//		}
//	}
//
//
//	/* Creating the Hashmap for the row */
//	private List createGroupList() {
//		ArrayList result = new ArrayList();
//		for (int i = 0; i < 4; ++i) { // 15 groups........
//			HashMap m = new HashMap();
//			m.put("Group Item", "GroupItems " + i); // the key and it's value.
//			result.add(m);
//		}
//		return (List) result;
//	}
//
//	/* creatin the HashMap for the children */
//	private List createChildList() {
//
//		ArrayList result = new ArrayList();
//		for (int i = 0; i < 15; ++i) { // this -15 is the number of groups(Here
//										// it's fifteen)
//			/*
//			 * each group need each HashMap-Here for each group we have 3
//			 * subgroups
//			 */
//			ArrayList secList = new ArrayList();
//			for (int n = 0; n < 3; n++) {
//				HashMap child = new HashMap();
//				child.put("Sub Item", "SubItem " + n);
//				secList.add(child);
//			}
//			result.add(secList);
//		}
//		return result;
//	}
//
//	public void onContentChanged() {
//		System.out.println("onContentChanged");
//		super.onContentChanged();
//	}
//
//	/* This function is called on each child click */
//	public boolean onChildClick(ExpandableListView parent, View v,
//			int groupPosition, int childPosition, long id) {
//		System.out
//				.println("Inside onChildClick at groupPosition = "
//						+ groupPosition + " Child clicked at position "
//						+ childPosition);
//		return true;
//	}
//
//	/* This function is called on expansion of the group */
//	public void onGroupExpand(int groupPosition) {
//		try {
//			System.out.println("Group exapanding Listener => groupPosition = "
//					+ groupPosition);
//		} catch (Exception e) {
//			System.out.println(" groupPosition Errrr +++ " + e.getMessage());
//		}
        }
        public class MyExpandableListAdapter extends BaseExpandableListAdapter {
            // Sample data set. children[i] contains the children (String[]) for
            // groups[i].
            private String[] groups = { "GroupItems 0", "GroupItems 1",
                    "GroupItems 2", "GroupItems 3" };
            private String[][] children = {
                    { "SubItem 0", "SubItem 1", "SubItem 2", "SubItem 3" },
                    { "SubItem 0", "SubItem 1", "SubItem 2", "SubItem 3" },
                    { "SubItem 0", "SubItem 1" },
                    { "SubItem 0", "SubItem 1", "SubItem 2", } };

            public Object getChild(int groupPosition, int childPosition) {
                return children[groupPosition][childPosition];
            }

            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            public int getChildrenCount(int groupPosition) {
                return children[groupPosition].length;
            }

//		public TextView getGenericView() {
//			// Layout parameters for the ExpandableListView
//			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
//					ViewGroup.LayoutParams.MATCH_PARENT, 64);
//
//			TextView textView = new TextView(MainActivity.this);
//			textView.setLayoutParams(lp);
//			// Center the text vertically
//			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
//			// Set the text starting position
//			textView.setPadding(36, 0, 0, 0);
//			return textView;
//		}

            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
//			TextView textView = getGenericView();
//			textView.setText(getChild(groupPosition, childPosition).toString());
//			return textView;
                final String
                        child_text = (String) getChild(groupPosition, childPosition);
                LayoutInflater
                        inflater = Expandablelist.this.getLayoutInflater();

                if (convertView == null) { convertView =
                        inflater.inflate(R.layout.child_row, null); }

                TextView item = (TextView) convertView.findViewById(R.id.grp_child);
                item.setText(child_text);
                return convertView;
            }

            public Object getGroup(int groupPosition) {
                return groups[groupPosition];
            }

            public int getGroupCount() {
                return groups.length;
            }

            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {
//			TextView textView = getGenericView();
//			textView.setText(getGroup(groupPosition).toString());
//			return textView;
                final String
                        child_text = (String) getGroup(groupPosition);
                LayoutInflater
                        inflater = Expandablelist.this.getLayoutInflater();

                if (convertView == null) { convertView =
                        inflater.inflate(R.layout.group_row, null); }

                TextView item = (TextView) convertView.findViewById(R.id.row_name);
                item.setText(child_text);
                return convertView;
            }

            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            public boolean hasStableIds() {
                return true;
            }
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }


