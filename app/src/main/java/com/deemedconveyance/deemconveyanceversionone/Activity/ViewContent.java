package com.deemedconveyance.deemconveyanceversionone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.deemedconveyance.deemconveyanceversionone.R;

import java.util.ArrayList;

public class ViewContent extends AppCompatActivity
{
    private TextView show_content;
    String item;
    ArrayList<String> obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        show_content = (TextView) findViewById(R.id.show_content);

        obj = new ArrayList<String>();
        obj.add("Conveyance of a Property is transferring the Rights, Title, Interest and Ownership of the Property from the Seller to the Purchaser.\n" +
                "\n" +
                "In case of a Co- Operative Housing Society (formed by the Flat Purchasers/ Owners under the provisions of Maharashtra Co- Operative Societies Act, 1960), Conveyance is transferring the Rights, Title, Interest and Ownership of the Land and Building from the Land Owner/ Property Developer to the Co- Operative Housing Society.\n" +
                "\n" +
                "As per the provisions under Section 11 of Maharashtra Ownership Flat Act, 1963, Conveyance is the Right of the Co- Operative Housing Society and the Duty of the Property Developer/ Promoter to be executed within 4 months from the date of Registration of the Co- Operative Housing Society.\n" +
                "\n" +
                "The Conveyance is to be executed by way of Conveyance Deed between the Land Owners & the Co- Operative Housing Society where the Property Developer is the Confirming Party. This Conveyance Deed is required to be Adjudicated & properly Stamped as per the Bombay Stamp Act, 1958 & thereafter Registered as per the Registration Act, 1908. It is required to obtain the Index II of the Registered Conveyance Deed. The copy of Registered Conveyance Deed along with the Index II is to be submitted to various Government Offices for change in the mutation entries of the Property.\n" +
                "\n" +
                "After the Land and Building is conveyed in favour of the Co-operative Housing Society and the Title of the property is fully and finally recorded in the Property Card and other Revenue Records then only the Co- Operative Housing Society becomes absolute owner of the Property & the Title of the Co- Operative Housing Society becomes completely free and marketable.");
        obj.add("A Co- Operative Housing Society is the owner of the Land & Building & individual member enjoys the ownership right of the Flat/ Shop based on the Share Certificate issued by the Co- Operative Housing Society.\n" +
                "\n" +
                "A vast majority of Co- Operative Housing Societies do not have the Conveyance in their favour & hence are not the owners of their Land & Building. In this situation, even though each member of the Co- Operative Housing Society has paid full consideration and is in possession of the Flat/ Shop allotted, he does not enjoy the benefits of title ownership of the Flat/ Shop.\n" +
                "\n" +
                "In case of Co- Operative Housing Societies formed long back, many of the Buildings are in dilapidated condition and their repairs are not economically viable. The best solution available for these Co- Operative Housing Societies is to go ahead with ReDevelopment. The non- availability of the Conveyance & therefore free/ marketable Title affects the ReDevelopment Process badly.\n" +
                "\n" +
                "In case of Co- Operative Housing Societies formed recently, the ReDevelopment at the moment is not on the agenda. However the non- availability of the Conveyance and free and marketable Title may affect its present Revenue and may be a hindrance in ReDevelopment process in future.\n" +
                "\n" +
                "Therefore Deemed Conveyance is in the larger interest of the Co- Operative Housing Societies (and their each and every member) who are denied their right of Conveyance by the Land- Owners & Property Developers.");
        obj.add("Deemed Conveyance is an Amendment under sub- section (3) of section 11 of the Maharashtra Ownership Flats (Regulation of the Promotion of Construction, Sale, Management and Transfer) Act, 1963.\n" +
                "\n" +
                "The essence of the Deemed Conveyance Amendment is as follows.\n" +
                "\n" +
                "Deemed Conveyance Amendment is applicable to the Societies that have not received Conveyance from the Land Owners & Property Developers within 4 Months of their formation.\n" +
                "The aggrieved Society shall make a Deemed Conveyance Application to the Competent Authority designated by Government of Maharashtra.\n" +
                "The Deemed Conveyance Application of the Society shall include the Documents notified by Government of Maharashtra for Deemed Conveyance.\n" +
                "The Competent Authority shall hear the say of the Land Owners & Property Developers.\n" +
                "The Competent Authority on satisfaction shall issue the Deemed Conveyance Order & Certificate in favour of the Aggrieved Society.\n" +
                "The Competent Authority shall execute the Deemed Conveyance Deed on behalf of the Defaulting Land Owners & Property Developers with the Aggrieved Society.");
        obj.add("Society will get Proper and Legal Title of the Property (Land & Structures) in the name of the Society\n" +
                "Society’s Property will be Free and Marketable\n" +
                "Society will retain Additional F.S.I granted by change of Development Regulations\n" +
                "Society can raise the Loans for Repairs and Reconstruction by mortgage of the Society’s Property\n" +
                "Society can get permission for reconstruction from the Planning Authorities\n" +
                "Society can ReDevelop the Property by constructing new building using TDR & Members can get the additional area (Fungible F. S. I.), new amenities & Corpus Fund\n" +
                "Society can receive additional Revenue of Rent from Advertising Hoarding & Tele- Communication Tower etc.");
        obj.add("The Procedure for Deemed Conveyance involves the following Stages\n" +
                "\n" +
                "Stage 1- Preparation for Deemed Conveyance\n" +
                "During this stage the Managing Committee prepares the Members of the Co- Operative Housing Society for Deemed Conveyance.\n" +
                "\n" +
                "Stage 2- Documentation for Deemed Conveyance\n" +
                "During this stage the Documents Required for Deemed Conveyance are collected/ organized & the Case is prepared.\n" +
                "\n" +
                "Stage 3- Legal Case for Deemed Conveyance\n" +
                "During this stage the case is filed before the Competent Authority & after contesting the same the Order & Certificate upholding the right of Deemed Conveyance of the Society is obtained.\n" +
                "\n" +
                "Stage 4- Registration of Deemed Conveyance\n" +
                "During this stage the Deemed Conveyance Deed is Adjudicated, properly Stamped & Registered.\n" +
                "\n" +
                "Stage 5- Transfer of Property after Deemed Conveyance\n" +
                "During this stage the Society Name is incorporated in the Land Revenue Records.");

        obj.add("This is a very important stage where the Managing Committee prepares the Members of Co- Operative Housing Society for the Deemed Conveyance.\n" +
                "The Managing Committee convenes a Special General Meeting (SGM) of the Society by giving suitable notice highlighting the agenda.\n" +
                "\n" +
                "The Managing Committee places before the SGM the difficulties faced for obtaining the Conveyance from the Land Owners/ Property Developers. The Managing Committee explains the effects of non- availability of Conveyance to the Members. The Managing Committee explains the Procedure & Benefits of Deemed Conveyance to the Members.\n" +
                "\n" +
                "During this SGM the following Resolutions are typically passed.\n" +
                "\n" +
                "Resolution for going ahead with Deemed Conveyance\n" +
                "Resolution for Appointment of Authorised Representative\n" +
                "Resolution for Appointment of Legal Consultant for Deemed Conveyance\n" +
                "Resolution for Per Member Contributions\n" +
                "After this stage only the Deemed Conveyance activity for the Society moves forward to the Documentation stage.");
        obj.add("Documentation is a very important & crucial stage in the Procedure for Deemed Conveyance. It requires absolute focus & meticulous handling to ensure that all the required documents are obtained & organized in an appropriate manner.\n" +
                "\n" +
                "The Land Revenue Records of recent origin are obtained by making applications to the respective Government Departments like City Survey Office, Tahasildar/ Talathi Office & District Collector Office. The Municipal Corporation Records are obtained by making application to the Building Proposal Department of the Municipal Corporation.\n" +
                "\n" +
                "In case it is difficult to obtain the Land Revenue Records & Municipal Corporation Records, the Right to Information (RTI) may be invoked.\n" +
                "\n" +
                "The Society Records are obtained from Society Office & the Professional Certificates are obtained from Professionals. Deemed Conveyance Application- Form VII along with Synopsis of the Case and List of Society Members are required to be prepared.\n" +
                "\n" +
                "During the Documentation Stage, a Legal Notice is to be sent to the Land Owners & Property developers.\n" +
                "\n" +
                "The complete set of the above Documents is to be annexed with the Deemed Conveyance Application- Form VII & to be filed in a neat & tidy manner. The complete Deemed Conveyance Application- Form VII is to submitted to the Competent Authority- The District Deputy Registrar of Co- Operative Societies of the particular District.");
        obj.add("On receipt of the Deemed Conveyance Application- Form VII, the Office of Competent Authority issues the Deemed Conveyance Scrutiny Report- Form VIII within about 1 month.\n" +
                "\n" +
                "When compliance is given to the Scrutiny Report the Office of Competent Authority issues Summons & Newspaper Notices to the Land Owners & Property Developers for appearing for the hearing.\n" +
                "\n" +
                "It is essential to record the say of the Land Owners & Property Developers if they appear before the Competent Authority for hearing. During the hearings the written replies, arguments, written arguments of the Land Owners & Property Developers are recorded. During the hearings the rejoinders, arguments & written arguments of the Society are also recorded. The hearings are typically concluded within 3- 4 months & the Deemed Conveyance Application file is closed for order.\n" +
                "\n" +
                "After the file is closed for order, the Office of Competent Authority issues the Deemed Conveyance Order within 1 month. The Legal Case for Deemed Conveyance is a time bound activity & is typically completed within 6 months.");
        obj.add("On receipt of the Deemed Conveyance Order, the Deemed Conveyance Deed between the Competent Authority & the Society is prepared. The Competent Authority appears in the Deed on behalf of the defaulting Land Owners & Property Developers.\n" +
                "\n" +
                "The Deemed Conveyance Deed is submitted to the Office of Competent Authority for Approval. The Competent Authority forwards the Deemed Conveyance Deed to the District Stamp Office for Adjudication. If all the Members of the Society have paid the Stamp Duty on their respective Flat/ Shop Agreements & there is no balance FSI, the Deemed Conveyance Deed attracts only Rs. 100/- Stamp Duty. The Stamp Office issues the Demand Notice.\n" +
                "\n" +
                "On receipt of the Demand Notice, the Society pays the required Stamp Duty & submits the Stamp Duty Payment Challan/ Receipt to the District Stamp Office. The District Stamp Office then defaces the Stamp Duty payment Challan/ Receipt & puts their Signature with Authority Stamp & Seal on the Deemed Conveyance Deed.\n" +
                "\n" +
                "The Competent Authority then puts their Signature with Authority Stamp & Seal on the Deemed Conveyance Deed. The Special General Body of the Society is called to approve the Deemed Conveyance Deed & to nominate 3 Members of the Society to sign the Deed.\n" +
                "\n" +
                "Thereafter the Deemed Conveyance Deed is submitted to the Registration Office for Registration. The Competent Authority is exempted from appearing for the Registration & hence the 3 Members nominated by the Society only appear for Registration and the Registration Office Registers the Deemed Conveyance Deed.\n" +
                "\n" +
                "After Registration of the Deemed Conveyance Deed, the Registration Office issues the Scanned Document & Index II.\n" +
                "\n" +
                "On receipt of the Index II, the Registration Process of the Deemed Conveyance Deed is successfully completed & the Society becomes the owner of the Land & Structure.");
        obj.add("On completion of the Registration of the Deemed Conveyance Deed & receipt of the Index II, the photocopies of the same are submitted along with relevant Applications to various Government Departments like City Survey Office, Tahasildar/ Talathi Office, District Collector Office & Municipal Corporation Office for change of Mutation entries in the Land Revenue Records & Property Tax Bills.\n" +
                "\n" +
                "On receipt of these Applications the Government departments effect the change of Mutation entries in the Land Revenue Records. On completion of the change of Mutation entries, the Land & Structures are transferred in favour of the Society.");
        obj.add("It is commonly observed that the Deemed Conveyance activity logically extends to the ReDevelopment of the Society. However some cautions are required to be exercised while handling both these procedures simultaneously.\n" +
                "\n" +
                "The Society may consider the beginning of ReDevelopment Procedure after filing the Deemed Conveyance Application before the Competent Authority.\n" +
                "\n" +
                "The Society may consider Memorandum of Understanding (MoU) with the incoming Property Developer after receipt of the Deemed Conveyance Order from the Competent Authority.\n" +
                "\n" +
                "The Society may consider Development Agreement (DA) with the incoming Property Developer after Registration of Deemed Conveyance Deed & Receipt of Index II.\n" +
                "\n" +
                "The Society may consider Power of Attorney to the incoming Property Developer on change of Mutation entries in the Land Revenue Records.");
        try {
            Bundle extras = getIntent().getExtras();
            item = extras.getString("item");
            Integer result = Integer.valueOf(item);
            String str= obj.get(result);
            show_content.setText(str);
        }
        catch (Exception e){

        }
    }
}
