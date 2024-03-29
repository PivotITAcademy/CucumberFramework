
package response.createStoreResponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateStoreResponse {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("type")
@Expose
private String type;
@SerializedName("address")
@Expose
private String address;
@SerializedName("address2")
@Expose
private String address2;
@SerializedName("city")
@Expose
private String city;
@SerializedName("state")
@Expose
private String state;
@SerializedName("zip")
@Expose
private String zip;
@SerializedName("lat")
@Expose
private Double lat;
@SerializedName("lng")
@Expose
private Double lng;
@SerializedName("hours")
@Expose
private String hours;
@SerializedName("updatedAt")
@Expose
private String updatedAt;
@SerializedName("createdAt")
@Expose
private String createdAt;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getAddress2() {
return address2;
}

public void setAddress2(String address2) {
this.address2 = address2;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getZip() {
return zip;
}

public void setZip(String zip) {
this.zip = zip;
}

public Double getLat() {
return lat;
}

public void setLat(Double lat) {
this.lat = lat;
}

public Double getLng() {
return lng;
}

public void setLng(Double lng) {
this.lng = lng;
}

public String getHours() {
return hours;
}

public void setHours(String hours) {
this.hours = hours;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

}
