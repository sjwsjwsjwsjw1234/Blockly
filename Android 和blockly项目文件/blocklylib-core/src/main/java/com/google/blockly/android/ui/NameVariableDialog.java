/*
 *  Copyright 2017 Google Inc. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.blockly.android.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.blockly.android.R;
import com.google.blockly.utils.LangUtils;

/**
 * Default dialog window shown when creating or renaming a variable in the workspace.
 */
public class NameVariableDialog extends DialogFragment {
    private String mVariable;
    private DialogInterface.OnClickListener mListener;
    private EditText mNameEditText;
    private boolean mIsRename;
    View nameView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceBundle) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        nameView = inflater.inflate(R.layout.name_variable_view, null);
        mNameEditText = (EditText) nameView.findViewById(R.id.name);
        mNameEditText.setText(mVariable);

        TextView description = (TextView) nameView.findViewById(R.id.description);
        if (mIsRename) {
            description.setText(
                LangUtils.interpolate("%{BKY_RENAME_VARIABLE_TITLE}").replace("%1", mVariable));
        } else {
            description.setText(LangUtils.interpolate("%{BKY_NEW_VARIABLE_TITLE}"));
        }

        AlertDialog.Builder bob = new AlertDialog.Builder(getActivity());
        bob.setTitle(LangUtils.interpolate("%{BKY_IOS_VARIABLES_VARIABLE_NAME}"));
        bob.setView(nameView);
        bob.setPositiveButton(LangUtils.interpolate("%{BKY_IOS_OK}"), mListener);
        bob.setNegativeButton(LangUtils.interpolate("%{BKY_IOS_CANCEL}"), mListener);
        return bob.create();
    }

    public void setVariable(String variable, final Callback clickListener, boolean isRename) {
        if (clickListener == null) {
            throw new IllegalArgumentException("Must have a listener to perform an action.");
        }
        mVariable = variable;
        mIsRename = isRename;
        mListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case AlertDialog.BUTTON_POSITIVE:
                        clickListener.onNameConfirmed(mVariable,
                                mNameEditText.getText().toString());
                        break;
                    case AlertDialog.BUTTON_NEGATIVE:
                        clickListener.onNameCanceled(mVariable);
                        break;
                }
            }
        };
    }

    public abstract static class Callback {
        public abstract void onNameConfirmed(String originalName, String newName);
        public void onNameCanceled(String originalName) {
            // Do nothing by default
        }
    }
}
