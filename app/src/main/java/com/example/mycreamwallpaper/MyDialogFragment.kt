package com.example.mycreamwallpaper

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

// TODO: BUG - dialogFragment doesn't show fully after fitting navigationBar
class MyDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogMore)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_detail_more, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // important here
        dialog?.setCanceledOnTouchOutside(true)

        dialog?.window?.setGravity(Gravity.BOTTOM)

        val params = dialog?.window?.attributes as WindowManager.LayoutParams
//        params.width = getScreenParam(requireContext(), DeviceUtils.SCREEN_WIDTH_PX)
        params.width = WindowManager.LayoutParams.MATCH_PARENT

        val downloadBtn: Button = view.findViewById(R.id.download_all_dialog_detail_more)
        val reportBtn: Button = view.findViewById(R.id.report_dialog_detail_more)
        val cancelBtn: Button = view.findViewById(R.id.cancel_dialog_detail_more)

        cancelBtn.setOnClickListener {
            dismiss()
        }

        downloadBtn.setOnClickListener {
            Toast.makeText(requireContext(), "click download!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        reportBtn.setOnClickListener {
            Toast.makeText(requireContext(), "click report!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}